package com.example.fgoapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult

class CalculatorFragmentRefund : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_calculator_refund, container, false)
        val editTextE1Hp: EditText = view.findViewById(R.id.editTextE1Hp)
        val editTextE2Hp: EditText = view.findViewById(R.id.editTextE2Hp)
        val editTextE3Hp: EditText = view.findViewById(R.id.editTextE3Hp)
        val editTextNpGain: EditText = view.findViewById(R.id.editTextNpGain)

        val spinnerE1Class: Spinner = view.findViewById(R.id.spinnerE1Class)
        val spinnerE2Class: Spinner = view.findViewById(R.id.spinnerE2Class)
        val spinnerE3Class: Spinner = view.findViewById(R.id.spinnerE3Class)

        val spinnerE1Trait: Spinner = view.findViewById(R.id.spinnerE1Trait)
        val spinnerE2Trait: Spinner = view.findViewById(R.id.spinnerE2Trait)
        val spinnerE3Trait: Spinner = view.findViewById(R.id.spinnerE3Trait)

        val spinnerAdapter: ImageSpinnerAdapter = ImageSpinnerAdapter(requireContext(), arrayOf(R.drawable.classicon_shielder, R.drawable.classicon_saber,
        R.drawable.classicon_archer, R.drawable.classicon_lancer, R.drawable.classicon_rider, R.drawable.classicon_caster,
        R.drawable.classicon_assassin, R.drawable.classicon_berserker, R.drawable.classicon_ruler, R.drawable.classicon_avenger,
        R.drawable.classicon_mooncancer, R.drawable.classicon_alterego, R.drawable.classicon_foreigner, R.drawable.classicon_pretender))

        val enemyTrait: List<String> = listOf("man", "earth", "sky", "star", "beast")
        val adapterSpinnerEnemyTrait: ArrayAdapter<String> =
            ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, enemyTrait)

        spinnerE1Class.adapter = spinnerAdapter
        spinnerE2Class.adapter = spinnerAdapter
        spinnerE3Class.adapter = spinnerAdapter

        spinnerE1Trait.adapter = adapterSpinnerEnemyTrait
        spinnerE2Trait.adapter = adapterSpinnerEnemyTrait
        spinnerE3Trait.adapter = adapterSpinnerEnemyTrait

        val buttonExit: Button = view.findViewById(R.id.buttonExitRefund)
        buttonExit.setOnClickListener{
            val npGainBuff: String? = when (editTextNpGain.text.isNotEmpty()){
                true -> editTextNpGain.text.toString()
                false -> null
            }

            val hp1: String? = when (editTextE1Hp.text.isNotEmpty()){
                true -> editTextE1Hp.text.toString()
                false -> null
            }

            val hp2: String? = when (editTextE2Hp.text.isNotEmpty()){
                true -> editTextE2Hp.text.toString()
                false -> null
            }

            val hp3: String? = when (editTextE3Hp.text.isNotEmpty()){
                true -> editTextE3Hp.text.toString()
                false -> null
            }

            /*
            0: shielder, 1: saber, 2: archer, 3: lancer, 4: rider, 5: caster, 6: assassin, 7: berserker, 8: ruler,
            9: avenger, 10: moon cancer, 11: alter ego, 12: foreigner, 13: pretender
            */

            val enemyClass1: String = (spinnerE1Class.selectedItemPosition).toString()
            val enemyClass2: String = (spinnerE2Class.selectedItemPosition).toString()
            val enemyClass3: String = (spinnerE3Class.selectedItemPosition).toString()

            val result = arrayOf(npGainBuff, hp1, enemyClass1, hp2, enemyClass2, hp3, enemyClass3)
            setFragmentResult("requestKey", bundleOf("data" to result))
        }

        return view
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