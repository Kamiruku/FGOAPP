package com.example.fgoapp

import android.app.Activity
import android.app.Application
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

class InitialStartUp : Application() {
    var servantInfoValue = getServantInfo()
    var servantName: List<String> = getServantNames(servantInfoValue)
    override fun onCreate() {
        super.onCreate()
    }

    fun getServInfoVal(): ServantDump{
        return servantInfoValue
    }

    fun getServName(): List<String>{
        return servantName
    }

    fun getServantNames(servantInfo: ServantDump):List<String>{
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
        for (servant in servantInfo){
            servantNames.add(servant.name)
        }

        return servantNames
    }
    fun getServantInfo():ServantDump{
        val jsonString = getJsonFromAssets()
        val servantInfo = Gson().fromJson(jsonString, ServantDump::class.java)

        return servantInfo
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

    fun getServantAtk(inputName: String, servantInfo: ServantDump): List<Int>{
        for (servant in servantInfo){
            if (inputName == servant.name){
                return servant.atkGrowth
            }
        }

        return emptyList()
    }
}