package com.example.fgoapp

import android.graphics.Rect
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.View.*
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.*
import com.example.fgoapp.MainActivity.Companion.servantInfoValue
import com.example.fgoapp.MainActivity.Companion.servantNames
import java.util.*


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

        var inputName: String = "Cat"
        var servantDetailsList: List<ServantDump.ServantDumpItem> = emptyList()
        var atkGrowth: List<Int> = listOf()
        var selectedLevel: String = "1"
        var servantAtk: Double = 1.0

        val textViewAtkStat: TextView = findViewById(R.id.textViewAtkStat)

        autoCompleteServantName.onItemClickListener = OnItemClickListener { arg0, arg1, arg2, arg3 ->
            inputName = arg0.getItemAtPosition(arg2).toString()
            servantDetailsList = data.getServantDetail(inputName, servantInfoValue)

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

                servantAtk = atkGrowth[selectedLevel.toInt() - 1].toDouble()
                textViewAtkStat.text = servantAtk.toInt().toString()
            }
        }

        autoCompleteServantLevel.onItemClickListener = OnItemClickListener { arg0, arg1, arg2, arg3 ->
            selectedLevel = arg0.getItemAtPosition(arg2).toString()

            if (servantDetailsList.isNotEmpty()) {
                servantAtk = atkGrowth[selectedLevel.toInt() - 1].toDouble()
                textViewAtkStat.text = servantAtk.toInt().toString()
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

        val view1: View = findViewById(R.id.view1)

        val buttonCalculateDamage : Button = findViewById(R.id.button_Calculate_Damage)
        buttonCalculateDamage.setOnClickListener {
            showDamage(view1, savedInstanceState, atkGrowth,npDamageMultiplier!!, servantAtk)
        }
    }
    private fun showDamage(view1: View, savedInstanceState: Bundle?, atkGrowth: List<Int>, npDamageMultiplier: Double, servantAtk: Double){
        val editTextCardBuffs: EditText = findViewById(R.id.editText_Card_Buff)
        val editTextAttackBuffs: EditText = findViewById(R.id.editText_Attack_Buff)
        val editTextNPDamageBuffs: EditText = findViewById(R.id.editText_NPDamage_Buff)
        val editTextPmodBuffs: EditText = findViewById(R.id.editText_Pmod_Buff)
        val editTextSEBuffs: EditText = findViewById(R.id.editText_SE_Buff)
        val editTextDMGPlus: EditText = findViewById(R.id.editText_DMGPlus_Buff)

        var cardMod:Double
        var atkMod:Double
        var npDamageMod:Double
        var powerMod:Double
        var superEffectiveModifier:Double
        var dmgPlusAdd:Double

        var lowRollDamage:Double
        var averageRollDamage:Double
        var highRollDamage:Double

        val frag = CalculatorFragment()
        val bundle = Bundle()

        cardMod = editTextToDouble(editTextCardBuffs) / 100
        atkMod = editTextToDouble(editTextAttackBuffs) / 100
        npDamageMod = editTextToDouble(editTextNPDamageBuffs) / 100
        powerMod = editTextToDouble(editTextPmodBuffs) / 100
        superEffectiveModifier = editTextToDouble(editTextSEBuffs) / 100
        dmgPlusAdd = editTextToDouble(editTextDMGPlus)

        view1.visibility = VISIBLE

        val fm: FragmentManager = supportFragmentManager
        val ft: FragmentTransaction = fm.beginTransaction()

        if (atkGrowth.isNotEmpty()){
            if (npDamageMultiplier != 0.0){
                lowRollDamage = calculateDamage(servantAtk, npDamageMultiplier!!, cardMod, 0.9, atkMod, powerMod, npDamageMod, superEffectiveModifier, dmgPlusAdd)
                averageRollDamage = calculateDamage(servantAtk, npDamageMultiplier!!, cardMod, 1.0, atkMod, powerMod, npDamageMod, superEffectiveModifier, dmgPlusAdd)
                highRollDamage = calculateDamage(servantAtk, npDamageMultiplier!!, cardMod, 1.1, atkMod, powerMod, npDamageMod, superEffectiveModifier, dmgPlusAdd)

                val damage = arrayOf<String>(lowRollDamage.toString(), averageRollDamage.toString(), highRollDamage.toString())

                if (savedInstanceState == null) {
                    Log.d("Help me", averageRollDamage.toString())
                    bundle.putStringArray("DamageBundle", damage)
                    frag.arguments = bundle
                    ft.replace(R.id.fragment_container_view, frag)
                    ft.show(frag)
                }
            }
            else{
                val damage = arrayOf<String>("0.00", "0.00", "0.00")
                if (savedInstanceState == null) {
                    bundle.putStringArray("DamageBundle", damage)
                    frag.arguments = bundle
                    ft.replace(R.id.fragment_container_view, frag)
                    ft.show(frag)
                }

                Toast.makeText(this, "You are trying to calculate damage for a support NP.", Toast.LENGTH_LONG).show()
            }
            ft.addToBackStack(null)
            ft.commit()
        }
        else{
            Toast.makeText(this, "Please select a servant.", Toast.LENGTH_LONG).show()
        }

        view1.setOnClickListener{ view ->
            val fm: FragmentManager = supportFragmentManager
            val ft: FragmentTransaction = fm.beginTransaction()
            ft.hide(frag)
            ft.commit()
            view1.visibility = INVISIBLE
        }
    }

    private fun calculateDamage(servantAtk: Double, npDamageMultiplier: Double, cardMod:Double, randomModifier: Double, atkMod:Double, powerMod:Double, npDamageMod:Double, superEffectiveModifier:Double, dmgPlusAdd:Double):Double{ val damage:Double

        val firstCardBonus:Double = 0.00 //0.5 if first card is a Buster card, 0 otherwise. No bonus to NPs
        val cardDamageValue:Double = 0.80
        val classAtkBonus:Double = 1.10
        val triangleModifier:Double = 1.00
        val attributeModifier:Double = 1.00
        val defMod:Double = 0.0
        val criticalModifier:Double = 1.00
        val extraCardModifier:Double = 1.00 //2 if Extra card in a Brave Chain, 3.5 if Extra card in a Buster/Quick/Arts Brave Chain, 1 if neither
        val specialDefMod:Double = 0.00
        val selfDamageMod:Double = 0.00
        val critDamageMod:Double = 0.00
        val isCrit:Int = 0 //1 if crit, 0 otherwise
        val isNP:Int = 1 //1 if NP attack, 0 otherwise
        val isSuperEffective:Int = 0 //1 if the enemy qualifies (via trait or status), 0 otherwise
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
        var output = input.text.toString().trim()

        return if (output.isEmpty()){
            0.00
        } else{
            output.toDouble()
        }
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}
