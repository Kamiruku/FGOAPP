package com.example.fgoapp

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.fgoapp.MainActivity.Companion.servantInfoValue
import com.example.fgoapp.MainActivity.Companion.servantNames
import java.io.InputStream

class Calculator : AppCompatActivity(), View.OnClickListener, CalculatorFragmentRefund.OnDataPass {
    var enemyDetails: List<String?> = emptyList()

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
        var classIcon: Bitmap?

        autoCompleteServantName.onItemClickListener = OnItemClickListener { arg0, _, arg2, _ ->
            inputName = arg0.getItemAtPosition(arg2).toString()
            servantDetailsList = data.getServantDetail(inputName, servantInfoValue)
            servantClass = servantDetailsList[0].className
            servantRarity = servantDetailsList[0].rarity

            servantRarityColour = when (servantRarity){
                1, 2 -> "bronze"
                3 -> "silver"
                4, 5 -> "gold"
                else -> "silver"
            }

            classIcon = loadBitmapFromAssets("classicons/$servantClass" + "_" + "$servantRarityColour.png")
            imageViewClassIcon.setImageBitmap(classIcon)

            atkGrowth = servantDetailsList[0].atkGrowth
            fou = fouCheck(editTextFou)

            if (atkGrowth.isNotEmpty()){
                npDamageMultiplier = if (data.getNPMultiplier(servantDetailsList[0]) != placeHolderForSupports){
                    data.getNPMultiplier(servantDetailsList[0])[nPLevel - 1].Value.toDouble() / 1000
                }
                else{ 0.00 }

                if (autoCompleteServantLevel.text.isNotEmpty()){
                    selectedLevel = autoCompleteServantLevel.text.toString()
                }

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

        autoCompleteServantLevel.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (autoCompleteServantLevel.text.isNotEmpty()){
                    if (autoCompleteServantLevel.text.toString().toInt() > 120){
                        autoCompleteServantLevel.setText("120")
                        selectedLevel = "120"
                    }
                    else if (autoCompleteServantLevel.text.toString() == "0"){
                        selectedLevel = "1"
                    }
                    else{
                        selectedLevel = autoCompleteServantLevel.text.toString()
                    }
                }

                if (atkGrowth.isNotEmpty()) {
                    fou = fouCheck(editTextFou)
                    servantAtk = atkGrowth[selectedLevel.toInt() - 1].toDouble() + fou
                    textViewAtkStat.text = getString(R.string.numberPlus, servantAtk.toInt().toString())
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        spinnerNPLevel.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                nPLevel = parent.getItemAtPosition(position).toString().trim().toInt()

                if (servantDetailsList.isNotEmpty()){
                    npDamageMultiplier = if (data.getNPMultiplier(servantDetailsList[0]) != placeHolderForSupports){
                        data.getNPMultiplier(servantDetailsList[0])[nPLevel - 1].Value.toDouble() / 1000
                    }
                    else{ 0.00 }
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        editTextFou.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                fou = fouCheck(editTextFou)
                if (servantDetailsList.isNotEmpty() && atkGrowth.isNotEmpty()) {
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
        val fragmentView: View = findViewById(R.id.fragment_container_view_results)
        fragmentView.visibility = INVISIBLE

        val buttonCalculateDamage : Button = findViewById(R.id.button_Calculate_Damage)
        buttonCalculateDamage.setOnClickListener {
            if (servantDetailsList.isNotEmpty()) {
                fou = fouCheck(editTextFou) //empty string or >2000 check
                servantClass = servantDetailsList[0].className
                servantNpType = servantDetailsList[0].noblePhantasms[servantDetailsList[0].noblePhantasms.size - 1].card
                servantAtk = atkGrowth[selectedLevel.toInt() - 1].toDouble() + fou //reupdates servant atk and displays it - redundant
                textViewAtkStat.text = getString(R.string.numberPlus, servantAtk.toInt().toString())
                showDamage(servantDetailsList[0], fragmentView, view1, servantClass, servantNpType, npDamageMultiplier!!, servantAtk)
            }
            else{
                //only occurs if user does not click anything from the suggestion box
                Toast.makeText(this, "Please select a servant from the suggestion box.", Toast.LENGTH_LONG).show()
            }
        }

        val activityBackground = (findViewById<View>(android.R.id.content) as ViewGroup).getChildAt(0) as ViewGroup
        activityBackground.setOnTouchListener(object : OnSwipeTouchListener(this@Calculator) {
            override fun onSwipeLeft() {
                val fm: FragmentManager = supportFragmentManager
                val ft: FragmentTransaction = fm.beginTransaction()
                val frag = CalculatorFragmentRefund()
                ft.replace(R.id.fragment_container_view_refund, frag)
                ft.commit()
            }
        })
    }

    private fun showDamage(servantInfo: ServantDump.ServantDumpItem, fragmentView: View, view1: View, servantClass: String, servantNpType: String, npDamageMultiplier: Double, servantAtk: Double){
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

        val isSuperEffective: Int = if (editTextSEBuffs.text.isNotEmpty()){ 1
        } else{ 0 }

        val fm: FragmentManager = supportFragmentManager
        val ft: FragmentTransaction = fm.beginTransaction()
        val frag = CalculatorFragment()
        val bundle = Bundle()

        val classAtkBonus = when (servantClass){
            "caster", "assassin" ->  0.9
            "archer" -> 0.95
            "saber", "rider", "shielder", "alterEgo", "foreigner", "pretender", "moonCancer", "beast" -> 1.0
            "lancer" ->  1.05
            "berserker" , "ruler", "avenger"->  1.1
            else -> 1.0
        }

        val cardDamageValue = when (servantNpType){
            "arts" -> 1.0
            "buster" -> 1.5
            "quick" -> 0.8
            else -> 1.0
        }

        val npDistribution: List<Int> = servantInfo.noblePhantasms[servantInfo.noblePhantasms.size - 1].npDistribution
        val offensiveNPRate: Double = servantInfo.noblePhantasms[servantInfo.noblePhantasms.size - 1].npGain.np[0].toDouble()

        if (npDamageMultiplier != 0.0){
            lowRollDamage = calculateDamage(servantAtk, classAtkBonus, cardDamageValue, npDamageMultiplier, cardMod, 0.9, atkMod, powerMod, npDamageMod, isSuperEffective, superEffectiveModifier, dmgPlusAdd)
            averageRollDamage = calculateDamage(servantAtk, classAtkBonus, cardDamageValue, npDamageMultiplier, cardMod, 1.0, atkMod, powerMod, npDamageMod, isSuperEffective, superEffectiveModifier, dmgPlusAdd)
            highRollDamage = calculateDamage(servantAtk, classAtkBonus, cardDamageValue, npDamageMultiplier, cardMod, 1.1, atkMod, powerMod, npDamageMod, isSuperEffective, superEffectiveModifier, dmgPlusAdd)

            if (enemyDetails.isNotEmpty()){
                val refund1 = if (enemyDetails[0] != null){
                    calculateNpRefund(offensiveNPRate, npDistribution, servantNpType, enemyDetails[0]!!.toDouble(), lowRollDamage, cardMod)
                }
                else{ 0.00 }

                val refund2 = if (enemyDetails[1] != null){
                    calculateNpRefund(offensiveNPRate, npDistribution, servantNpType, enemyDetails[1]!!.toDouble(), lowRollDamage, cardMod)

                }
                else{ 0.00 }

                val refund3 = if (enemyDetails[2] != null){
                    calculateNpRefund(offensiveNPRate, npDistribution, servantNpType, enemyDetails[0]!!.toDouble(), lowRollDamage, cardMod)
                }
                else{ 0.00 }

                val refundTotal = doubleArrayOf(refund1, refund2, refund3)
                bundle.putDoubleArray("TotalRefund", refundTotal)
            }

            val damage = arrayOf<String>(lowRollDamage.toString(), averageRollDamage.toString(), highRollDamage.toString())
            bundle.putStringArray("DamageBundle", damage)
            frag.arguments = bundle
            ft.replace(R.id.fragment_container_view_results, frag)
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

        val damage = (servantAtk * npDamageMultiplier *  (firstCardBonus + (cardDamageValue * (1 + cardMod))) * classAtkBonus *
                triangleModifier * attributeModifier * randomModifier * 0.23 * (1 + atkMod - defMod) * criticalModifier *
                extraCardModifier * (1 - specialDefMod) *  (1 + powerMod + selfDamageMod + (critDamageMod * isCrit) +
                (npDamageMod * isNP)) * (1 + ((superEffectiveModifier - 1) * isSuperEffective))) + dmgPlusAdd +
                selfDmgCutAdd + (servantAtk * busterChainMod)

        return damage.round(2)
    }

    private fun calculateNpRefund(offensiveNPRate: Double, npDistribution: List<Int>, servantNpType: String, enemyHp: Double, damage: Double, cardMod: Double): Double{
        var enemyHpPlace: Double = enemyHp
        var npRefund: Double = 0.0
        var oKH: Int = 0
        var index: Int = 0

        while (index < npDistribution.size){
            enemyHpPlace -= (npDistribution[index] * damage) / 100

            if (enemyHpPlace < 0){
                oKH++
            }
            ++index
        }

        val refundFromOKH = calculateHitRefund(offensiveNPRate, servantNpType, cardMod, 1.5) * oKH
        val refundFromNormal = calculateHitRefund(offensiveNPRate, servantNpType, cardMod,1.0) * (npDistribution.size - oKH)

        return refundFromNormal + refundFromOKH
    }

    private fun calculateHitRefund(offensiveNPRate: Double, servantNpType: String, cardMod: Double, overkillModifier: Double): Double{
        val NP: Double
        val firstCardBonus: Double = 0.00
        val cardNpValue: Double = when (servantNpType){
            "arts" -> 3.0
            "buster" -> 0.0
            "quick" -> 1.0
            else -> 1.0
        }

        val enemyServerMod: Double = 1.00 //caster = 1.20, berserker = 0.80, etc
        val npChargeRateMod: Double = 0.00
        val criticalModifier: Int = 1 //not a crit

        val hitRefund: Double =  ((offensiveNPRate / 100 * (firstCardBonus + (cardNpValue * (1 + cardMod))) * enemyServerMod * (1 + npChargeRateMod) * criticalModifier) * overkillModifier)
        return hitRefund
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
            if (output.toDouble() > 4000){
                input.setText("2000")
                4000.00
            } else{
                output.toDouble()
            }
        }
    }

    private fun loadBitmapFromAssets(path: String?): Bitmap? {
        var inputStream: InputStream? = null

        return try {
            inputStream = assets.open(path!!)
            BitmapFactory.decodeStream(inputStream)
        }
        catch (ignored: Exception) {
            null
        }
        finally{
            inputStream!!.close()
        }
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    override fun onDataPass(data: List<String?>) {
        enemyDetails = data
    }
}
