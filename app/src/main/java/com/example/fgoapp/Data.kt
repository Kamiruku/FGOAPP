package com.example.fgoapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.io.IOException
import java.io.InputStream
import java.text.NumberFormat
import java.util.*
import com.google.gson.Gson
import java.nio.charset.Charset
import android.content.res.AssetManager

class Data(var context: Context) {

    var servantName: List<String> = listOf()

    fun getServantNames():List<String>{
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
        val servantNames: MutableList<String> = mutableListOf()
        val servants = getServantInfo()
        for (servant in servants){
            servantNames.add(" " + servant.name + " " + servant.className + " " + servant.rarity + " star(s)")
        }

        return servantNames
    }
    fun getServantInfo():ServantDump{
        val jsonString = getJsonFromAssets()
        val servantInfo = Gson().fromJson(jsonString, ServantDump::class.java)

        return servantInfo
    }

    fun getJsonFromAssets(): String? {
        var json: String? = null
        var charset: Charset = Charsets.UTF_8
        try {
            val jsonFile = this.context.assets.open("nice_servant.json")
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