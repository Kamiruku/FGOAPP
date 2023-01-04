package com.example.fgoapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.*

class CalculatorFragmentRefund : Fragment() {
    lateinit var dataPasser: OnDataPass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        dataPasser = context as OnDataPass
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_calculator_refund, container, false)
        val editTextEnemyOneHp: EditText = view.findViewById(R.id.editTextEnemyOneHp)
        val editTextEnemyTwoHp: EditText = view.findViewById(R.id.editTextEnemyTwoHp)
        val editTextEnemyThreeHp: EditText = view.findViewById(R.id.editTextEnemyThreeHp)
        val editTextNpGain: EditText = view.findViewById(R.id.editTextNpGain)

        val spinnerEnemyOneClass: Spinner = view.findViewById(R.id.spinnerEnemyOneClass)
        val spinnerEnemyTwoClass: Spinner = view.findViewById(R.id.spinnerEnemyTwoClass)
        val spinnerEnemyThreeClass: Spinner = view.findViewById(R.id.spinnerEnemyThreeClass)

        val spinnerAdapter: ImageSpinnerAdapter = ImageSpinnerAdapter(requireContext(), arrayOf(R.drawable.classicon_shielder, R.drawable.classicon_saber,
        R.drawable.classicon_archer, R.drawable.classicon_lancer, R.drawable.classicon_rider, R.drawable.classicon_caster,
        R.drawable.classicon_assassin, R.drawable.classicon_berserker, R.drawable.classicon_ruler, R.drawable.classicon_avenger,
        R.drawable.classicon_mooncancer, R.drawable.classicon_alterego, R.drawable.classicon_foreigner, R.drawable.classicon_pretender))

        spinnerEnemyOneClass.adapter = spinnerAdapter
        spinnerEnemyTwoClass.adapter = spinnerAdapter
        spinnerEnemyThreeClass.adapter = spinnerAdapter

        var dataPassed: List<String?>

        /*
        if (arguments != null){
            val existingEnemies = requireArguments().getStringArray("EnemyDetails")
            editTextNpGain.setText(existingEnemies?.get(0) ?: String())
            editTextEnemyOneHp.setText(existingEnemies?.get(1) ?: String())
            editTextEnemyTwoHp.setText(existingEnemies?.get(2) ?: String())
            editTextEnemyThreeHp.setText(existingEnemies?.get(3) ?: String())
        }
        */

        val buttonExit: Button = view.findViewById(R.id.buttonExitRefund)
        buttonExit.setOnClickListener{
            val npGainBuff: String? = when (editTextNpGain.text.isNotEmpty()){
                true -> editTextNpGain.text.toString()
                false -> null
            }

            val hp1: String? = when (editTextEnemyOneHp.text.isNotEmpty()){
                true -> editTextEnemyOneHp.text.toString()
                false -> null
            }

            val hp2: String? = when (editTextEnemyTwoHp.text.isNotEmpty()){
                true -> editTextEnemyTwoHp.text.toString()
                false -> null
            }

            val hp3: String? = when (editTextEnemyThreeHp.text.isNotEmpty()){
                true -> editTextEnemyThreeHp.text.toString()
                false -> null
            }

            /*
            0: shielder, 1: saber, 2: archer, 3: lancer, 4: rider, 5: caster, 6: assassin, 7: berserker, 8: ruler,
            9: avenger, 10: moon cancer, 11: alter ego, 12: foreigner, 13: pretender
            */

            val enemyClass1: String = (spinnerEnemyOneClass.selectedItemPosition).toString()
            val enemyClass2: String = (spinnerEnemyTwoClass.selectedItemPosition).toString()
            val enemyClass3: String = (spinnerEnemyThreeClass.selectedItemPosition).toString()

            dataPassed = listOf(npGainBuff, hp1, enemyClass1, hp2, enemyClass2, hp3, enemyClass3)
            passData(dataPassed)
        }

        return view
    }

    interface OnDataPass {
        fun onDataPass(data: List<String?>)
    }

    fun passData(data: List<String?>){
        dataPasser.onDataPass(data)
    }
}

class ImageSpinnerAdapter(context: Context, images: Array<Int>) :
    ArrayAdapter<Int>(context, android.R.layout.simple_spinner_item, images) {

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup) =
        getImageForPosition(position)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup) =
        getImageForPosition(position)

    private fun getImageForPosition(position: Int) = ImageView(context).apply {
        setBackgroundResource(getItem(position)!!)
        layoutParams = ViewGroup.LayoutParams(125, 125)
    }
}