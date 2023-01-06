package com.example.fgoapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.gson.Gson
import java.io.File
import java.io.IOException
import java.nio.charset.Charset


class MainActivity : AppCompatActivity() {
    companion object{
        var servantInfoValue: ServantDump = ServantDump()
        var servantNames: List<String> = listOf()
        val data = Data()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        servantInfoValue = data.getServantInfo(getJsonFromAssets())
        servantNames = data.getServantNames(servantInfoValue)

        /*
        val gson = Gson()

        var servantInfoValue2: ServantDump2 = (gson.fromJson(getJsonFromAssets(), ServantDump2::class.java))
        var string = gson.toJson(servantInfoValue2)

        val path = getFilesDir()
        val letDirectory = File(path, "LET")
        letDirectory.mkdirs()
        val file = File(letDirectory, "Records.txt")
        file.appendText(string)

        println(string)
         */

        val buttonToCalculator: Button = findViewById(R.id.button_To_Calculator)
        buttonToCalculator.setOnClickListener {
            startActivity(Intent(this, Calculator::class.java))
        }
    }

    private fun getJsonFromAssets(): String? {
        val json: String?
        val charset: Charset = Charsets.UTF_8
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

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            data.hideDecor(window)
        }
    }
}