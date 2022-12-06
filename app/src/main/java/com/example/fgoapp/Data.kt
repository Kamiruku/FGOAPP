package com.example.fgoapp

import com.google.gson.Gson


class Data {
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
}