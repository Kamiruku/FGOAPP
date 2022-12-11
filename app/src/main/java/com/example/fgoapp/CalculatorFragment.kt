package com.example.fgoapp

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CalculatorFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_calculator, container, false)
        val textLowRollDamage: TextView = view.findViewById(R.id.text_Damage_Low_Roll_Fragment)
        val textAverageRollDamage: TextView = view.findViewById(R.id.text_Damage_Average_Roll_Fragment)
        val textHighRollDamage: TextView = view.findViewById(R.id.text_Damage_High_Roll_Fragment)

        if (arguments != null){
            val damage = requireArguments().getStringArray("DamageBundle")
            textLowRollDamage.text = damage?.get(0)?.toString()
            textAverageRollDamage.text = damage?.get(1)?.toString()
            textHighRollDamage.text = damage?.get(2)?.toString()
        }
        return view
    }

    override fun onAttach(activity: Activity){
        super.onAttach(activity)
    }
}