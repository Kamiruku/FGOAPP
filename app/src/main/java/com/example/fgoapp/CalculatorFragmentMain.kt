package com.example.fgoapp

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.fgoapp.Calculator.Companion.enemyDetails
import java.io.InputStream

class CalculatorFragmentMain : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_calculator_main, container, false)

        val data = Data()
        val placeHolderForSupports = listOf(ServantDump.ServantDumpItem.NoblePhantasm.Function.Sval(0, 0))

        val classBonus = arrayOf(
            doubleArrayOf(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0),
            doubleArrayOf(1.0, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0),
            doubleArrayOf(1.0, 2.0, 1.0, 0.5, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0),
            doubleArrayOf(1.0, 0.5, 2.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0),
            doubleArrayOf(1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 2.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0),
            doubleArrayOf(1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 2.0, 2.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0),
            doubleArrayOf(1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 2.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0),
            doubleArrayOf(1.0, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 0.5, 1.5),
            doubleArrayOf(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0),
            doubleArrayOf(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 1.0, 0.5, 1.0, 1.0, 1.0),
            doubleArrayOf(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 2.0, 1.0, 1.0, 1.0, 1.0),
            doubleArrayOf(1.0, 0.5, 0.5, 0.5, 1.5, 1.5, 1.5, 2.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5),
            doubleArrayOf(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 0.5, 2.0, 2.0),
            doubleArrayOf(1.0, 1.5, 1.5, 1.5, 0.5, 0.5, 0.5, 2.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0)
        )

        //Set up the autocomplete servant name field
        val autoCompleteServantName: AutoCompleteTextView = view.findViewById(R.id.autoCompleteServantName)
        val adapterAutoCompleteNames: ArrayAdapter<String> =
            ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, MainActivity.servantNames)

        autoCompleteServantName.threshold = 1
        autoCompleteServantName.setAdapter(adapterAutoCompleteNames)
        adapterAutoCompleteNames.notifyDataSetChanged()

        //Number of levels for servant level
        val levels: MutableList<String> = mutableListOf()
        for (i in 1 until 121){
            levels.add(i.toString())
        }

        //Sets up the autocomplete servant level field (1-120)
        val autoCompleteServantLevel: AutoCompleteTextView = view.findViewById(R.id.autoCompleteServantLevel)
        val adapterAutoCompleteLevel: ArrayAdapter<String> =
            ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, levels)

        autoCompleteServantLevel.threshold = 1
        autoCompleteServantLevel.setAdapter(adapterAutoCompleteLevel)
        adapterAutoCompleteLevel.notifyDataSetChanged()

        //Number of levels for NP level
        val npLevels: Array<String> = arrayOf(" 1 ", " 2 ", " 3 ", " 4 ", " 5 ")

        //Sets up the spinner for NP Level field (1-5)
        val spinnerNPLevel: Spinner = view.findViewById(R.id.spinnerNPLevel)
        val adapterSpinnerNPLevel: ArrayAdapter<String> =
            ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, npLevels)
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

        val textViewAtkStat: TextView = view.findViewById(R.id.textViewAtkStat)
        val editTextFou: EditText = view.findViewById(R.id.editTextFou)
        var fou: Double

        val imageViewClassIcon: ImageView = view.findViewById(R.id.imageViewClassIcon)
        var classIcon: Bitmap?

        autoCompleteServantName.onItemClickListener =
            AdapterView.OnItemClickListener { arg0, _, arg2, _ ->
                inputName = arg0.getItemAtPosition(arg2).toString()
                servantDetailsList = data.getServantDetail(inputName, MainActivity.servantInfoValue)
                servantClass = servantDetailsList[0].className
                servantRarity = servantDetailsList[0].rarity

                servantRarityColour = when (servantRarity) {
                    1, 2 -> "bronze"
                    3 -> "silver"
                    4, 5 -> "gold"
                    else -> "silver"
                }

                classIcon =
                    loadBitmapFromAssets("classicons/$servantClass" + "_" + "$servantRarityColour.png")
                imageViewClassIcon.setImageBitmap(classIcon)

                atkGrowth = servantDetailsList[0].atkGrowth
                fou = fouCheck(editTextFou)

                if (atkGrowth.isNotEmpty()) {
                    npDamageMultiplier =
                        if (data.getNPMultiplier(servantDetailsList[0]) != placeHolderForSupports) {
                            data.getNPMultiplier(servantDetailsList[0])[nPLevel - 1].Value.toDouble() / 1000
                        } else {
                            0.00
                        }

                    if (autoCompleteServantLevel.text.isNotEmpty()) {
                        selectedLevel = autoCompleteServantLevel.text.toString()
                    }

                    servantAtk = atkGrowth[selectedLevel.toInt() - 1].toDouble() + fou
                    textViewAtkStat.text =
                        getString(R.string.numberPlus, servantAtk.toInt().toString())
                }
            }

        autoCompleteServantLevel.onItemClickListener =
            AdapterView.OnItemClickListener { arg0, _, arg2, _ ->
                selectedLevel = arg0.getItemAtPosition(arg2).toString()

                if (servantDetailsList.isNotEmpty()) {
                    fou = fouCheck(editTextFou)
                    servantAtk = atkGrowth[selectedLevel.toInt() - 1].toDouble() + fou
                    textViewAtkStat.text =
                        getString(R.string.numberPlus, servantAtk.toInt().toString())
                }
            }

        autoCompleteServantLevel.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (autoCompleteServantLevel.text.isNotEmpty()){
                    if (autoCompleteServantLevel.text.toString().toInt() > 120){
                        autoCompleteServantLevel.setText(R.string.onehundredtwenty)
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
        val view1: View = view.findViewById(R.id.view1)
        view1.visibility = View.INVISIBLE
        val fragmentView: View = view.findViewById(R.id.fragment_container_view_results)
        fragmentView.visibility = View.INVISIBLE

        val buttonCalculateDamage : Button = view.findViewById(R.id.button_Calculate_Damage)
        buttonCalculateDamage.setOnClickListener {
            if (servantDetailsList.isNotEmpty()) {
                fou = fouCheck(editTextFou) //empty string or >2000 check
                servantClass = servantDetailsList[0].className
                servantNpType = servantDetailsList[0].noblePhantasms[servantDetailsList[0].noblePhantasms.size - 1].card
                servantAtk = atkGrowth[selectedLevel.toInt() - 1].toDouble() + fou //reupdates servant atk and displays it - redundant
                textViewAtkStat.text = getString(R.string.numberPlus, servantAtk.toInt().toString())
                showDamage(classBonus, servantDetailsList[0], fragmentView, view1, servantClass, servantNpType, npDamageMultiplier!!, servantAtk)
            }
            else{
                //only occurs if user does not click anything from the suggestion box
                Toast.makeText(requireContext(), "Please select a servant from the suggestion box.", Toast.LENGTH_LONG).show()
            }
        }

        return view
    }

    private fun showDamage(classBonus: Array<DoubleArray>, servantInfo: ServantDump.ServantDumpItem, fragmentView: View, view1: View, servantClass: String, servantNpType: String, npDamageMultiplier: Double, servantAtk: Double){
        val editTextCardBuffs: EditText = requireView().findViewById(R.id.editText_Card_Buff)
        val editTextAttackBuffs: EditText = requireView().findViewById(R.id.editText_Attack_Buff)
        val editTextNPDamageBuffs: EditText = requireView().findViewById(R.id.editText_NPDamage_Buff)
        val editTextPmodBuffs: EditText = requireView().findViewById(R.id.editText_Pmod_Buff)
        val editTextSEBuffs: EditText = requireView().findViewById(R.id.editText_SE_Buff)
        val editTextDMGPlus: EditText = requireView().findViewById(R.id.editText_DMGPlus_Buff)

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

        val fm: FragmentManager = (activity as Calculator).supportFragmentManager
        val ft: FragmentTransaction = fm.beginTransaction()
        val frag = CalculatorFragmentResults()
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

        var advantage: Double
        var enemyServerMod: Double

        if (npDamageMultiplier != 0.0){
            lowRollDamage = calculateDamage(servantAtk, classAtkBonus, cardDamageValue, npDamageMultiplier, cardMod, 0.9, atkMod, powerMod, npDamageMod, isSuperEffective, superEffectiveModifier, dmgPlusAdd)
            averageRollDamage = calculateDamage(servantAtk, classAtkBonus, cardDamageValue, npDamageMultiplier, cardMod, 1.0, atkMod, powerMod, npDamageMod, isSuperEffective, superEffectiveModifier, dmgPlusAdd)
            highRollDamage = calculateDamage(servantAtk, classAtkBonus, cardDamageValue, npDamageMultiplier, cardMod, 1.1, atkMod, powerMod, npDamageMod, isSuperEffective, superEffectiveModifier, dmgPlusAdd)

            if (enemyDetails.isNotEmpty()){
                if (enemyDetails[0] != null){
                    val npChargeRateMod = enemyDetails[0]!!.toDouble() / 100
                    Log.d("NP", npChargeRateMod.toString())

                    advantage = checkClassBonus(classBonus, convertClassStringToNumber(servantClass), enemyDetails[2]!!)
                    enemyServerMod = returnEnemyServerMod(enemyDetails[2]!!)

                    val refundLow1 = if (enemyDetails[1] != null){
                        calculateNpRefund(npChargeRateMod, offensiveNPRate, npDistribution, servantNpType, enemyDetails[1]!!.toDouble(), lowRollDamage * advantage, cardMod, enemyServerMod)
                    }
                    else{ 0.00 }

                    val refundHigh1 = if (enemyDetails[1] != null){
                        calculateNpRefund(npChargeRateMod, offensiveNPRate, npDistribution, servantNpType, enemyDetails[1]!!.toDouble(), highRollDamage * advantage, cardMod, enemyServerMod)
                    }
                    else{ 0.00 }

                    advantage = checkClassBonus(classBonus, convertClassStringToNumber(servantClass), enemyDetails[4]!!)
                    enemyServerMod = returnEnemyServerMod(enemyDetails[4]!!)

                    val refundLow2 = if (enemyDetails[3] != null){
                        calculateNpRefund(npChargeRateMod, offensiveNPRate, npDistribution, servantNpType, enemyDetails[3]!!.toDouble(), lowRollDamage * advantage, cardMod, enemyServerMod)
                    }
                    else{ 0.00 }

                    val refundHigh2 = if (enemyDetails[3] != null){
                        calculateNpRefund(npChargeRateMod, offensiveNPRate, npDistribution, servantNpType, enemyDetails[3]!!.toDouble(), highRollDamage * advantage, cardMod, enemyServerMod)
                    }
                    else{ 0.00 }

                    advantage = checkClassBonus(classBonus, convertClassStringToNumber(servantClass), enemyDetails[6]!!)
                    enemyServerMod = returnEnemyServerMod(enemyDetails[6]!!)

                    val refundLow3 = if (enemyDetails[5] != null){
                        calculateNpRefund(npChargeRateMod, offensiveNPRate, npDistribution, servantNpType, enemyDetails[5]!!.toDouble(), lowRollDamage * advantage, cardMod, enemyServerMod)
                    }
                    else{ 0.00 }

                    val refundHigh3 = if (enemyDetails[5] != null){
                        calculateNpRefund(npChargeRateMod, offensiveNPRate, npDistribution, servantNpType, enemyDetails[5]!!.toDouble(), highRollDamage * advantage, cardMod, enemyServerMod)
                    }
                    else{ 0.00 }

                    val refundLowTotal = doubleArrayOf(refundLow1, refundLow2, refundLow3)
                    val refundHighTotal = doubleArrayOf(refundHigh1, refundHigh2, refundHigh3)
                    bundle.putDoubleArray("TotalRefundLow", refundLowTotal)
                    bundle.putDoubleArray("TotalRefundHigh", refundHighTotal)
                }
                else{
                    advantage = checkClassBonus(classBonus, convertClassStringToNumber(servantClass), enemyDetails[2]!!)
                    enemyServerMod = returnEnemyServerMod(enemyDetails[2]!!)

                    val refundLow1 = if (enemyDetails[1] != null){
                        calculateNpRefund(0.0, offensiveNPRate, npDistribution, servantNpType, enemyDetails[1]!!.toDouble(), lowRollDamage * advantage, cardMod, enemyServerMod)
                    }
                    else{ 0.00 }

                    val refundHigh1 = if (enemyDetails[1] != null){
                        calculateNpRefund(0.0, offensiveNPRate, npDistribution, servantNpType, enemyDetails[1]!!.toDouble(), highRollDamage * advantage, cardMod, enemyServerMod)
                    }
                    else{ 0.00 }

                    advantage = checkClassBonus(classBonus, convertClassStringToNumber(servantClass), enemyDetails[4]!!)
                    enemyServerMod = returnEnemyServerMod(enemyDetails[4]!!)

                    val refundLow2 = if (enemyDetails[3] != null){
                        calculateNpRefund(0.0, offensiveNPRate, npDistribution, servantNpType, enemyDetails[3]!!.toDouble(), lowRollDamage * advantage, cardMod, enemyServerMod)
                    }
                    else{ 0.00 }

                    val refundHigh2 = if (enemyDetails[3] != null){
                        calculateNpRefund(0.0, offensiveNPRate, npDistribution, servantNpType, enemyDetails[3]!!.toDouble(), highRollDamage * advantage, cardMod, enemyServerMod)
                    }
                    else{ 0.00 }

                    advantage = checkClassBonus(classBonus, convertClassStringToNumber(servantClass), enemyDetails[6]!!)
                    enemyServerMod = returnEnemyServerMod(enemyDetails[6]!!)

                    val refundLow3 = if (enemyDetails[5] != null){
                        calculateNpRefund(0.0, offensiveNPRate, npDistribution, servantNpType, enemyDetails[5]!!.toDouble(), lowRollDamage * advantage, cardMod, enemyServerMod)
                    }
                    else{ 0.00 }

                    val refundHigh3 = if (enemyDetails[5] != null){
                        calculateNpRefund(0.0, offensiveNPRate, npDistribution, servantNpType, enemyDetails[5]!!.toDouble(), highRollDamage * advantage, cardMod, enemyServerMod)
                    }
                    else{ 0.00 }

                    val refundLowTotal = doubleArrayOf(refundLow1, refundLow2, refundLow3)
                    val refundHighTotal = doubleArrayOf(refundHigh1, refundHigh2, refundHigh3)
                    bundle.putDoubleArray("TotalRefundLow", refundLowTotal)
                    bundle.putDoubleArray("TotalRefundHigh", refundHighTotal)
                }
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
            Toast.makeText(requireContext(), "You are trying to calculate damage for a support NP.", Toast.LENGTH_LONG).show()
        }
        ft.addToBackStack(null)
        ft.commit()
        view1.visibility = View.VISIBLE
        fragmentView.visibility = View.VISIBLE

        view1.setOnClickListener{
            view1.visibility = View.INVISIBLE
            fragmentView.visibility = View.INVISIBLE
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

    private fun calculateNpRefund(npChargeRateMod: Double, offensiveNPRate: Double, npDistribution: List<Int>, servantNpType: String, enemyHp: Double, damage: Double, cardMod: Double, enemyServerMod: Double): Double{
        var enemyHpPlace: Double = enemyHp
        var oKH: Int = 0
        var index: Int = 0

        while (index < npDistribution.size){
            enemyHpPlace -= (npDistribution[index] * damage) / 100

            if (enemyHpPlace < 0){
                oKH++
            }
            ++index
        }

        val refundFromOKH = calculateHitRefund(npChargeRateMod, offensiveNPRate, servantNpType, cardMod, 1.5, enemyServerMod) * oKH
        val refundFromNormal = calculateHitRefund(npChargeRateMod, offensiveNPRate, servantNpType, cardMod,1.0, enemyServerMod) * (npDistribution.size - oKH)

        return refundFromNormal + refundFromOKH
    }

    private fun calculateHitRefund(npChargeRateMod: Double, offensiveNPRate: Double, servantNpType: String, cardMod: Double, overkillModifier: Double, enemyServerMod: Double): Double{
        val firstCardBonus: Double = 0.00
        val cardNpValue: Double = when (servantNpType){
            "arts" -> 3.0
            "buster" -> 0.0
            "quick" -> 1.0
            else -> 1.0
        }

        val criticalModifier: Int = 1 //not a crit

        val hitRefund: Double =  ((offensiveNPRate / 100 * (firstCardBonus + (cardNpValue * (1 + cardMod))) * enemyServerMod * (1 + npChargeRateMod) * criticalModifier) * overkillModifier)
        return hitRefund.round(2)
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
                input.setText(R.string.fourthousand)
                4000.00
            } else{
                output.toDouble()
            }
        }
    }

    private fun loadBitmapFromAssets(path: String?): Bitmap? {
        var inputStream: InputStream? = null

        return try {
            inputStream = requireContext().assets.open(path!!)
            BitmapFactory.decodeStream(inputStream)
        }
        catch (ignored: Exception) {
            null
        }
        finally{
            inputStream!!.close()
        }
    }

    private fun convertClassStringToNumber(enemyClass: String): String{
        return when(enemyClass){
            "shielder" -> "0"
            "saber" -> "1"
            "archer" -> "2"
            "lancer" -> "3"
            "rider" -> "4"
            "caster" -> "5"
            "assassin" -> "6"
            "berserker" -> "7"
            "ruler" -> "8"
            "avenger" -> "9"
            "moonCancer" -> "10"
            "alterEgo" -> "11"
            "foreigner" -> "12"
            "pretender" -> "13"
            else -> "0"
        }
    }

    private fun checkClassBonus(classBonus: Array<DoubleArray>, servant: String, enemy: String): Double{
        return classBonus[servant.toInt()][enemy.toInt()]
    }

    private fun returnEnemyServerMod(enemyClass: String): Double{
        return when (enemyClass){
            "7" -> 0.8
            "6" -> 0.9
            "4" -> 1.1
            "5" -> 1.2
            else -> 1.0
        }
    }
}