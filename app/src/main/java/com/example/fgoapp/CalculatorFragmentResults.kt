package com.example.fgoapp

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.text.NumberFormat
import java.util.*

class CalculatorFragmentResults : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_calculator_results, container, false)

        val textLowRollDamage: TextView = view.findViewById(R.id.text_Damage_Low_Roll_Fragment)
        val textAverageRollDamage: TextView = view.findViewById(R.id.text_Damage_Average_Roll_Fragment)
        val textHighRollDamage: TextView = view.findViewById(R.id.text_Damage_High_Roll_Fragment)

        val imageView: ImageView = view.findViewById(R.id.imageView)
        imageView.setBackgroundColor(Color.rgb(81, 45, 128))

        val textLabelRefund: TextView = view.findViewById(R.id.text_Refund_Label_Fragment)
        textLabelRefund.visibility = INVISIBLE
        val textRefund: TextView = view.findViewById(R.id.text_refund)
        textRefund.visibility = INVISIBLE
        val imageViewBottom: ImageView = view.findViewById(R.id.imageViewBottom)
        imageViewBottom.visibility = INVISIBLE

        if (arguments != null){
            val damage = requireArguments().getStringArray("DamageBundle")
            textLowRollDamage.text = getString(R.string.numberPlus, NumberFormat.getNumberInstance(Locale.US).format(damage?.get(0)?.toDouble()))
            textAverageRollDamage.text = getString(R.string.numberPlus, NumberFormat.getNumberInstance(Locale.US).format(damage?.get(1)?.toDouble()))
            textHighRollDamage.text = getString(R.string.numberPlus, NumberFormat.getNumberInstance(Locale.US).format(damage?.get(2)?.toDouble()))

            val refundLow = requireArguments().getDoubleArray("TotalRefundLow")
            val refundHigh = requireArguments().getDoubleArray("TotalRefundHigh")
            if (refundLow != null && refundHigh != null){
                textLabelRefund.visibility = VISIBLE
                textRefund.visibility = VISIBLE
                imageViewBottom.visibility = VISIBLE
                textRefund.text = getString(R.string.numberPlus, (refundLow[0] + refundLow[1] + refundLow[2]).round(2).toString()
                + " ~ " + (refundHigh[0] + refundHigh[1] + refundHigh[2]).round(2).toString())
            }
        }
        return view
    }

    private fun Double.round(decimals: Int): Double {
        var multiplier = 1.0
        repeat(decimals) { multiplier *= 10 }
        return kotlin.math.round(this * multiplier) / multiplier
    }
}