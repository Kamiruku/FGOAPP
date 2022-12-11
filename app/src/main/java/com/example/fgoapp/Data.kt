package com.example.fgoapp

import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import java.util.logging.Logger


class Data{
    fun getServantNames(servantInfo: ServantDump):List<String>{
        val servantNames: MutableList<String> = mutableListOf()
        val servantsWithSameName: List<String> = listOf("Lancelot", "Medusa", "Altria Pendragon (Alter)", "Cú Chulainn")
        for (servant in servantInfo){
            if (servant.name !in servantsWithSameName){
                servantNames.add(servant.name)
            }
            else{
                servantNames.add(servant.name + "\u00a0" + "(${servant.className.replaceFirstChar { it.uppercase() }})")
            }
        }
        return servantNames
    }
    fun getServantInfo(jsonString: String?): ServantDump {
        return Gson().fromJson(jsonString, ServantDump::class.java)
    }

    fun getServantDetail(inputName: String, servantInfo: ServantDump): List<ServantDump.ServantDumpItem>{
        val details = inputName.trim().split("\u00a0")

        for (servants in servantInfo){
            if ((details.size == 1) and (details[0].trim() == servants.name)){
                return listOf(servants)
            }
            else if ((details.size > 1) && ((details[0].trim() == servants.name) and (details[1].replace("[^A-Za-z0-9]".toRegex(), "").trim().lowercase() == servants.className))){
                return listOf(servants)
            }
        }
        return emptyList()
    }

    fun getNPMultiplier(servantDetails: ServantDump.ServantDumpItem): List<ServantDump.ServantDumpItem.NoblePhantasm.Function.Sval>{
        val placeholderForSupports = ServantDump.ServantDumpItem.NoblePhantasm.Function.Sval(0, 0)

        if (servantDetails.noblePhantasms[servantDetails.noblePhantasms.size - 1].effectFlags[0] != "support"){
            for (functions in servantDetails.noblePhantasms[servantDetails.noblePhantasms.size - 1].functions){
                if (functions.funcType.take(8) == "damageNp"){
                    return functions.svals
                }
            }
        }
        else if (servantDetails.noblePhantasms[servantDetails.noblePhantasms.size - 1].effectFlags[0] == "support"){
            return listOf(placeholderForSupports)
        }

        return emptyList()
    }
}