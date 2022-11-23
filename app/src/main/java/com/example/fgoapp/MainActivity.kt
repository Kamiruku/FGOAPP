package com.example.fgoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.gson.Gson
import java.io.IOException
import java.nio.Buffer
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonToCalculator: Button = findViewById(R.id.button_To_Calculator)
        buttonToCalculator.setOnClickListener {
            startActivity(Intent(this, Calculator::class.java))
        }

        val instanceOfData = Data(this)
        instanceOfData.servantName = instanceOfData.getServantNames()
    }
}