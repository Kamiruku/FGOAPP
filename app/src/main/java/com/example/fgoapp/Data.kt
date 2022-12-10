package com.example.fgoapp

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import java.util.logging.Logger


class Data{
    fun getServantNames(servantInfo: ServantDump):List<String>{
        val servantNames: MutableList<String> = mutableListOf()
        for (servant in servantInfo){
            servantNames.add(servant.name)
        }

        return servantNames
    }
    fun getServantInfo(jsonString: String?): ServantDump {
        return Gson().fromJson(jsonString, ServantDump::class.java)
    }

    fun getServantAtk(inputName: String, servantInfo: ServantDump): List<Int>{
        for (servant in servantInfo){
            if (inputName == servant.name){
                return servant.atkGrowth
            }
        }

        return emptyList()
    }

    fun getNPMultiplier(inputName: String, servantInfo: ServantDump): List<ServantDump.ServantDumpItem.NoblePhantasm.Function.Sval>{
        val placeholderForSupports = ServantDump.ServantDumpItem.NoblePhantasm.Function.Sval(0, 0)

        for (servants in servantInfo){
            if ((inputName == servants.name) and (servants.noblePhantasms[servants.noblePhantasms.size - 1].effectFlags[0] != "support")){
                Log.d("Cat1", servants.noblePhantasms.size.toString())
                for (functions in servants.noblePhantasms[servants.noblePhantasms.size - 1].functions){
                    Log.d("Cat2", "2")
                    if (functions.funcType == "damageNp" || functions.funcType == "damageNpIndividual"){
                        Log.d("Cat3", "3")
                        return functions.svals
                    }
                }
            }
            else if ((inputName == servants.name) and (servants.noblePhantasms[servants.noblePhantasms.size - 1].effectFlags[0] == "support")){
                Log.d("Cat4", "4")
                return listOf(placeholderForSupports)
            }
        }
        return emptyList()
    }
}