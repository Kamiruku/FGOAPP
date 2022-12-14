package com.example.fgoapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

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

        var dataPassed: List<String>

        val buttonExit: Button = view.findViewById(R.id.buttonExitRefund)
        buttonExit.setOnClickListener{
            dataPassed = listOf(editTextEnemyOneHp.text.toString(), editTextEnemyTwoHp.text.toString(),
                editTextEnemyThreeHp.text.toString()
            )

            val manager = requireActivity().supportFragmentManager
            manager.beginTransaction().remove(this).commit()
        }

        return view
    }

    interface OnDataPass {
        fun onDataPass(data: List<String>)
    }

    fun passData(data: List<String>){
        dataPasser.onDataPass(data)
    }
}