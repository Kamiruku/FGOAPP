package com.example.fgoapp

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.fgoapp.MainActivity.Companion.servantInfoValue
import com.example.fgoapp.MainActivity.Companion.servantNames
import java.io.InputStream

class Calculator : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val data = Data()
        val placeHolderForSupports = listOf(ServantDump.ServantDumpItem.NoblePhantasm.Function.Sval(0, 0))

        //Set up the autocomplete servant name field
        val autoCompleteServantName: AutoCompleteTextView = findViewById(R.id.autoCompleteServantName)
        val adapterAutoCompleteNames: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, servantNames)

        autoCompleteServantName.threshold = 1
        autoCompleteServantName.setAdapter(adapterAutoCompleteNames)
        adapterAutoCompleteNames.notifyDataSetChanged()

        //Number of levels for servant level
        val levels: MutableList<String> = mutableListOf()
        for (i in 1 until 121){
            levels.add(i.toString())
        }

        //Sets up the autocomplete servant level field (1-120)
        val autoCompleteServantLevel: AutoCompleteTextView = findViewById(R.id.autoCompleteServantLevel)
        val adapterAutoCompleteLevel: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, levels)

        autoCompleteServantLevel.threshold = 1
        autoCompleteServantLevel.setAdapter(adapterAutoCompleteLevel)
        adapterAutoCompleteLevel.notifyDataSetChanged()

        //Number of levels for NP level
        val npLevels = arrayOf<String>(" 1 ", " 2 ", " 3 ", " 4 ", " 5 ")

        //Sets up the spinner for NP Level field (1-5)
        val spinnerNPLevel: Spinner = findViewById(R.id.spinnerNPLevel)
        val adapterSpinnerNPLevel: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, npLevels)
        spinnerNPLevel.adapter = adapterSpinnerNPLevel

        //Preset Values to Calculate Damage
        var nPLevel: Int = 1
        var npDamageMultiplier: Double? = null

        var inputName: String
        var servantDetailsList: List<ServantDump.ServantDumpItem> = emptyList()
        var atkGrowth: List<Int> = listOf()
        var selectedLevel: String = "1"
        var servantAtk: Double
        var servantClass: String
        var servantRarity: Int
        var servantRarityColour: String
        var servantNpType: String

        val textViewAtkStat: TextView = findViewById(R.id.textViewAtkStat)
        val editTextFou: EditText = findViewById(R.id.editTextFou)
        var fou: Double

        val imageViewClassIcon: ImageView = findViewById(R.id.imageViewClassIcon)

        autoCompleteServantName.onItemClickListener = OnItemClickListener { arg0, _, arg2, _ ->
            inputName = arg0.getItemAtPosition(arg2).toString()
            servantDetailsList = data.getServantDetail(inputName, servantInfoValue)
            servantClass = servantDetailsList[0].className
            servantRarity = servantDetailsList[0].rarity

            when(servantRarity){
                1, 2 -> servantRarityColour = "bronze"
                3 -> servantRarityColour = "silver"
                4, 5 -> servantRarityColour = "gold"
                else -> servantRarityColour = "silver"
            }

            val classIcon = loadBitmapFromAssets("classicons/" + servantClass + "_" + servantRarityColour + ".png")
            imageViewClassIcon.setImageBitmap(classIcon)

            if (servantDetailsList.isNotEmpty()){
                atkGrowth = servantDetailsList[0].atkGrowth
            }

            if (atkGrowth.isNotEmpty()){
                npDamageMultiplier = if (data.getNPMultiplier(servantDetailsList[0]) != placeHolderForSupports){
                    data.getNPMultiplier(servantDetailsList[0])[nPLevel - 1].Value.toDouble() / 1000
                }
                else{
                    0.00
                }

                fou = fouCheck(editTextFou)
                servantAtk = atkGrowth[selectedLevel.toInt() - 1].toDouble() + fou
                textViewAtkStat.text = getString(R.string.numberPlus, servantAtk.toInt().toString())
            }
        }

        autoCompleteServantLevel.onItemClickListener = OnItemClickListener { arg0, _, arg2, _ ->
            selectedLevel = arg0.getItemAtPosition(arg2).toString()

            if (servantDetailsList.isNotEmpty()) {
                fou = fouCheck(editTextFou)
                servantAtk = atkGrowth[selectedLevel.toInt() - 1].toDouble() + fou
                textViewAtkStat.text = getString(R.string.numberPlus, servantAtk.toInt().toString())
            }
        }

        spinnerNPLevel.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                if (servantDetailsList.isNotEmpty()){
                    nPLevel = parent.getItemAtPosition(position).toString().trim().toInt()
                    npDamageMultiplier = if (data.getNPMultiplier(servantDetailsList[0]) != placeHolderForSupports){
                        data.getNPMultiplier(servantDetailsList[0])[nPLevel - 1].Value.toDouble() / 1000
                    }
                    else{
                        0.00
                    }
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        editTextFou.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (servantDetailsList.isNotEmpty() && atkGrowth.isNotEmpty()) {
                    fou = fouCheck(editTextFou)
                    servantAtk = atkGrowth[selectedLevel.toInt() - 1].toDouble() + fou
                    textViewAtkStat.text = getString(R.string.numberPlus, servantAtk.toInt().toString())
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        //Initialised here so it can be used in and out of show damage method
        val view1: View = findViewById(R.id.view1)
        view1.visibility = INVISIBLE
        val fragmentView: View = findViewById(R.id.fragment_container_view)
        fragmentView.visibility = INVISIBLE

        val buttonCalculateDamage : Button = findViewById(R.id.button_Calculate_Damage)
        buttonCalculateDamage.setOnClickListener {
            if (servantDetailsList.isNotEmpty()) {
                fou = fouCheck(editTextFou) //empty string or >2000 check
                servantClass = servantDetailsList[0].className
                servantNpType = servantDetailsList[0].noblePhantasms[servantDetailsList[0].noblePhantasms.size - 1].card
                servantAtk = atkGrowth[selectedLevel.toInt() - 1].toDouble() + fou //reupdates servant atk and use it
                textViewAtkStat.text = getString(R.string.numberPlus, servantAtk.toInt().toString())
                showDamage(fragmentView, view1, servantClass, servantNpType, npDamageMultiplier!!, servantAtk)
            }
            else{
                //only occurs if user does not click anything from the suggestion box
                Toast.makeText(this, "Please select a servant from the suggestion box.", Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun showDamage(fragmentView: View, view1: View, servantClass: String, servantNpType: String, npDamageMultiplier: Double, servantAtk: Double){
        val editTextCardBuffs: EditText = findViewById(R.id.editText_Card_Buff)
        val editTextAttackBuffs: EditText = findViewById(R.id.editText_Attack_Buff)
        val editTextNPDamageBuffs: EditText = findViewById(R.id.editText_NPDamage_Buff)
        val editTextPmodBuffs: EditText = findViewById(R.id.editText_Pmod_Buff)
        val editTextSEBuffs: EditText = findViewById(R.id.editText_SE_Buff)
        val editTextDMGPlus: EditText = findViewById(R.id.editText_DMGPlus_Buff)

        val lowRollDamage:Double
        val averageRollDamage:Double
        val highRollDamage:Double

        val cardMod:Double = editTextToDouble(editTextCardBuffs) / 100
        val atkMod:Double = editTextToDouble(editTextAttackBuffs) / 100
        val npDamageMod:Double = editTextToDouble(editTextNPDamageBuffs) / 100
        val powerMod:Double = editTextToDouble(editTextPmodBuffs) / 100
        val superEffectiveModifier:Double = editTextToDouble(editTextSEBuffs) / 100
        val dmgPlusAdd:Double = editTextToDouble(editTextDMGPlus)

        val isSuperEffective: Int = if (editTextSEBuffs.text.isNotEmpty()){
            1
        } else{
            0
        }

        val fm: FragmentManager = supportFragmentManager
        val ft: FragmentTransaction = fm.beginTransaction()
        val frag = CalculatorFragment()
        val bundle = Bundle()

        var classAtkBonus: Double = 1.0

        when (servantClass){
            "saber" -> classAtkBonus = 1.0
            "archer" -> classAtkBonus = 0.95
            "lancer" -> classAtkBonus = 1.05
            "rider" -> classAtkBonus = 1.0
            "caster" -> classAtkBonus = 0.9
            "assassin" -> classAtkBonus = 0.9
            "berserker" -> classAtkBonus = 1.1
            "shielder" -> classAtkBonus = 1.0
            "ruler" -> classAtkBonus = 1.1
            "alterEgo" -> classAtkBonus = 1.0
            "avenger" -> classAtkBonus = 1.1
            "beast" -> classAtkBonus = 1.0
            "foreigner" -> classAtkBonus = 1.0
            "pretender" -> classAtkBonus = 1.0
            "moonCancer" -> classAtkBonus = 1.0
        }

        var cardDamageValue: Double = 1.0

        when (servantNpType){
            "arts" -> cardDamageValue = 1.0
            "buster" -> cardDamageValue = 1.5
            "quick" -> cardDamageValue = 0.8
        }

        if (npDamageMultiplier != 0.0){
            lowRollDamage = calculateDamage(servantAtk, classAtkBonus, cardDamageValue, npDamageMultiplier, cardMod, 0.9, atkMod, powerMod, npDamageMod, isSuperEffective, superEffectiveModifier, dmgPlusAdd)
            averageRollDamage = calculateDamage(servantAtk, classAtkBonus, cardDamageValue, npDamageMultiplier, cardMod, 1.0, atkMod, powerMod, npDamageMod, isSuperEffective, superEffectiveModifier, dmgPlusAdd)
            highRollDamage = calculateDamage(servantAtk, classAtkBonus, cardDamageValue, npDamageMultiplier, cardMod, 1.1, atkMod, powerMod, npDamageMod, isSuperEffective, superEffectiveModifier, dmgPlusAdd)

            val damage = arrayOf<String>(lowRollDamage.toString(), averageRollDamage.toString(), highRollDamage.toString())
            bundle.putStringArray("DamageBundle", damage)
            frag.arguments = bundle
            ft.replace(R.id.fragment_container_view, frag)
            ft.show(frag)
        }
        else{
            /* val damage = arrayOf<String>("0.00", "0.00", "0.00")
            bundle.putStringArray("DamageBundle", damage)
            frag.arguments = bundle
            ft.replace(R.id.fragment_container_view, frag)
            ft.show(frag) */
            Toast.makeText(this, "You are trying to calculate damage for a support NP.", Toast.LENGTH_LONG).show()
        }
        ft.addToBackStack(null)
        ft.commit()
        view1.visibility = VISIBLE
        fragmentView.visibility = VISIBLE

        view1.setOnClickListener{
            view1.visibility = INVISIBLE
            fragmentView.visibility = INVISIBLE
        }
    }

    private fun calculateDamage(servantAtk: Double, classAtkBonus: Double, cardDamageValue: Double, npDamageMultiplier: Double, cardMod:Double, randomModifier: Double, atkMod:Double, powerMod:Double, npDamageMod:Double, isSuperEffective: Int, superEffectiveModifier:Double, dmgPlusAdd:Double):Double{
        val damage:Double

        val firstCardBonus:Double = 0.00 //0.5 if first card is a Buster card, 0 otherwise. No bonus to NPs
        val triangleModifier:Double = 1.00 //Depends on class of enemy but can be 0.5 -> 2.0
        val attributeModifier:Double = 1.00 //Can be 0.9, 1.0, or 1.1
        val defMod:Double = 0.0
        val criticalModifier:Double = 1.00
        val extraCardModifier:Double = 1.00 //2 if Extra card in a Brave Chain, 3.5 if Extra card in a Buster/Quick/Arts Brave Chain, 1 if neither
        val specialDefMod:Double = 0.00
        val selfDamageMod:Double = 0.00
        val critDamageMod:Double = 0.00
        val isCrit:Int = 0 //1 if crit, 0 otherwise
        val isNP:Int = 1 //1 if NP attack, 0 otherwise
        val selfDmgCutAdd:Double = 0.00
        val busterChainMod:Double = 0.00 //0.2 if it's a Buster card in a Buster Chain, 0 otherwise

        damage = (servantAtk * npDamageMultiplier *  (firstCardBonus + (cardDamageValue * (1 + cardMod))) * classAtkBonus *
                triangleModifier * attributeModifier * randomModifier * 0.23 * (1 + atkMod - defMod) * criticalModifier *
                extraCardModifier * (1 - specialDefMod) *  (1 + powerMod + selfDamageMod + (critDamageMod * isCrit) +
                (npDamageMod * isNP)) * (1 + ((superEffectiveModifier - 1) * isSuperEffective))) + dmgPlusAdd +
                selfDmgCutAdd + (servantAtk * busterChainMod)

        return damage.round(2)
    }

    private fun Double.round(decimals: Int): Double {
        var multiplier = 1.0
        repeat(decimals) { multiplier *= 10 }
        return kotlin.math.round(this * multiplier) / multiplier
    }

    private fun editTextToDouble(input: EditText):Double{
        val output = input.text.toString().trim()

        return if (output.isEmpty()){
            0.00
        } else{
            output.toDouble()
        }
    }

    private fun fouCheck(input: EditText): Double{
        val output = input.text.toString()
        return if (output.isEmpty()){
            0.00
        } else{
            if (output.toDouble() > 2000){
                2000.00
            } else{
                output.toDouble()
            }
        }
    }

    private fun loadBitmapFromAssets(path: String?): Bitmap? {
        return try {
            val inputStream: InputStream = assets.open(path!!)
            BitmapFactory.decodeStream(inputStream)
        } catch (ignored: Exception) {
            null
        }
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}
