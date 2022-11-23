package com.example.fgoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.io.IOException
import java.io.InputStream
import java.text.NumberFormat
import java.util.*
import com.google.gson.Gson
import java.nio.charset.Charset

class Calculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val servantName: AutoCompleteTextView = findViewById(R.id.autoCompleteServantName)
        val adapter: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getServant())

        servantName.threshold = 1;
        servantName.setAdapter(adapter)

        val buttonCalculateDamage: Button = findViewById(R.id.button_Calculate_Damage)
        val textLowRollDamage: TextView = findViewById(R.id.text_Damage_Low_Roll)
        val textAverageRollDamage: TextView = findViewById(R.id.text_Damage_Average_Roll)
        val textHighRollDamage: TextView = findViewById(R.id.text_Damage_High_Roll)

        val editTextCardBuffs: EditText = findViewById(R.id.editText_Card_Buff)
        val editTextAttackBuffs: EditText = findViewById(R.id.editText_Attack_Buff)
        val editTextNPDamageBuffs: EditText = findViewById(R.id.editText_NPDamage_Buff)
        val editTextPmodBuffs: EditText = findViewById(R.id.editText_Pmod_Buff)
        var editTextSEBuffs: EditText = findViewById(R.id.editText_SE_Buff)
        var editTextDMGPlus: EditText = findViewById(R.id.editText_DMGPlus_Buff)

        var cardMod:Double
        var atkMod:Double
        var npDamageMod:Double
        var powerMod:Double
        var superEffectiveModifier:Double
        var dmgPlusAdd:Double

        var lowRollDamage:Double
        var averageRollDamage:Double
        var highRollDamage:Double

        buttonCalculateDamage.setOnClickListener{
            cardMod = editTextToDouble(editTextCardBuffs) / 100
            atkMod = editTextToDouble(editTextAttackBuffs) / 100
            npDamageMod = editTextToDouble(editTextNPDamageBuffs) / 100
            powerMod = editTextToDouble(editTextPmodBuffs) / 100
            superEffectiveModifier = editTextToDouble(editTextSEBuffs) / 100
            dmgPlusAdd = editTextToDouble(editTextDMGPlus)

            lowRollDamage = calculateDamage(cardMod, 0.9, atkMod, powerMod, npDamageMod, superEffectiveModifier, dmgPlusAdd)
            averageRollDamage = calculateDamage(cardMod, 1.0, atkMod, powerMod, npDamageMod, superEffectiveModifier, dmgPlusAdd)
            highRollDamage = calculateDamage(cardMod, 1.1, atkMod, powerMod, npDamageMod, superEffectiveModifier, dmgPlusAdd)

            textLowRollDamage.text = " " + NumberFormat.getNumberInstance(Locale.US)
                .format(lowRollDamage)
            textAverageRollDamage.text = " " + NumberFormat.getNumberInstance(Locale.US)
                .format(averageRollDamage)
            textHighRollDamage.text = " " + NumberFormat.getNumberInstance(Locale.US)
                .format(highRollDamage)
        }
    }

    fun calculateDamage(cardMod:Double, randomModifier: Double,  atkMod:Double, powerMod:Double, npDamageMod:Double, superEffectiveModifier:Double,
                        dmgPlusAdd:Double):Double{
        var damage:Double

        var servantAtk:Double
        var npDamageMultiplier:Double
        var firstCardBonus:Double //0.5 if first card is a Buster card, 0 otherwise. No bonus to NPs
        var cardDamageValue:Double
        var classAtkBonus:Double
        var triangleModifier:Double
        var attributeModifier:Double
        var defMod:Double
        var criticalModifier:Double
        var extraCardModifier:Double //2 if Extra card in a Brave Chain, 3.5 if Extra card in a Buster/Quick/Arts Brave Chain, 1 if neither
        var specialDefMod:Double
        var selfDamageMod:Double
        var critDamageMod:Double
        var isCrit:Int //1 if crit, 0 otherwise
        var isNP:Int //1 if NP attack, 0 otherwise
        var isSuperEffective:Int //1 if the enemy qualifies (via trait or status), 0 otherwise
        var selfDmgCutAdd:Double
        var busterChainMod:Double //0.2 if it's a Buster card in a Buster Chain, 0 otherwise

        servantAtk = 13641.00
        npDamageMultiplier = 11.00
        firstCardBonus = 0.00
        cardDamageValue = 0.80
        classAtkBonus = 1.10
        triangleModifier = 1.00
        attributeModifier = 1.00
        defMod = 0.0
        criticalModifier = 1.00
        extraCardModifier = 1.00
        specialDefMod = 0.00
        selfDamageMod = 0.00
        critDamageMod = 0.00
        isCrit = 0
        isNP = 1
        isSuperEffective = 0
        selfDmgCutAdd = 0.00
        busterChainMod = 0.00

        damage = (servantAtk * npDamageMultiplier *  (firstCardBonus + (cardDamageValue * (1 + cardMod))) * classAtkBonus *
                triangleModifier * attributeModifier * randomModifier * 0.23 * (1 + atkMod - defMod) * criticalModifier *
                extraCardModifier * (1 - specialDefMod) *  (1 + powerMod + selfDamageMod + (critDamageMod * isCrit) +
                (npDamageMod * isNP)) * (1 + ((superEffectiveModifier - 1) * isSuperEffective))) + dmgPlusAdd +
                selfDmgCutAdd + (servantAtk * busterChainMod)

        return damage.round(2)
    }

    fun Double.round(decimals: Int): Double {
        var multiplier = 1.0
        repeat(decimals) { multiplier *= 10 }
        return kotlin.math.round(this * multiplier) / multiplier
    }

    fun editTextToDouble(input: EditText):Double{
        var output = input.text.toString().trim()

        return if (output.isEmpty()){
            0.00
        } else{
            output.toDouble()
        }
    }

    fun getServant():List<String>{
        /*var servantNames: List<String>
        val output: String

        val input: InputStream
        try {
            input = assets.open("servantDetails.csv")
            val size: Int = input.available()
            val buffer = ByteArray(size)
            input.read(buffer)
            output = String(buffer)

            // byte buffer into a string
            servantNames = output.split(",")
        } catch (e: IOException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
            return emptyList()
        }*/
        val mainActivity = MainActivity()

        val servantNames: MutableList<String> = mutableListOf()
        val servants = getServants()
        for (servant in servants){
            servantNames.add(" " + servant.name + " " + servant.className + " " + servant.rarity + " star(s)")
        }

        return servantNames
    }
    fun getServants():ServantDump{
        val jsonString = getJsonFromAssets()
        val servants = Gson().fromJson(jsonString, ServantDump::class.java)

        return servants
    }

    fun getJsonFromAssets(): String? {
        var json: String? = null
        var charset: Charset = Charsets.UTF_8
        try {
            val jsonFile = assets.open("nice_servant.json")
            val size = jsonFile.available()
            val buffer = ByteArray(size)
            jsonFile.read(buffer)
            jsonFile.close()
            json = String(buffer, charset)
        }
        catch(ex: IOException){
            ex.printStackTrace()
            return null
        }
        return json
    }
}
