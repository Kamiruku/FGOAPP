package com.example.fgoapp

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.text.NumberFormat
import java.util.*

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

        val imageView: ImageView = view.findViewById(R.id.imageView)
        imageView.setBackgroundColor(Color.rgb(81, 45, 128))

        if (arguments != null){
            val damage = requireArguments().getStringArray("DamageBundle")
            textLowRollDamage.text = getString(R.string.numberPlus, NumberFormat.getNumberInstance(Locale.US).format(damage?.get(0)?.toDouble()))
            textAverageRollDamage.text = getString(R.string.numberPlus, NumberFormat.getNumberInstance(Locale.US).format(damage?.get(1)?.toDouble()))
            textHighRollDamage.text = getString(R.string.numberPlus, NumberFormat.getNumberInstance(Locale.US).format(damage?.get(2)?.toDouble()))
        }
        return view
    }
}