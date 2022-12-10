package com.example.fgoapp

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException
import java.nio.charset.Charset


class MainActivity : AppCompatActivity() {
    companion object{
        var servantInfoValue: ServantDump = ServantDump()
        var servantNames: List<String> = listOf()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = Data()
        servantInfoValue = data.getServantInfo(getJsonFromAssets())
        servantNames = data.getServantNames(servantInfoValue)

        val buttonToCalculator: Button = findViewById(R.id.button_To_Calculator)
        buttonToCalculator.setOnClickListener {
            startActivity(Intent(this, Calculator::class.java))
        }
    }

    fun getJsonFromAssets(): String? {
        var json: String?
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