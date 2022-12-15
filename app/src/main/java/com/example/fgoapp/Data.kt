package com.example.fgoapp

import android.content.Context
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.Window
import com.google.gson.Gson
import kotlin.math.abs


class Data{
    fun hideDecor(window: Window) {
        try {
            val decorView: View = window.decorView
            decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            )
            decorView.setOnSystemUiVisibilityChangeListener { visibility ->
                if ((visibility) == 0) {
                    decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_FULLSCREEN)
                } else {
                    decorView.setSystemUiVisibility(
                        (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                or View.SYSTEM_UI_FLAG_FULLSCREEN
                                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
                    )
                }
            }
        } catch (ignored: Exception) { }
    }

    fun getServantNames(servantInfo: ServantDump):List<String>{
        val servantNames: MutableList<String> = mutableListOf()
        val servantsWithSameName: List<String> = listOf("Altria Pendragon (Alter)", "BB", "Brynhild", "Cú Chulainn", "Diarmuid Ua Duibhne",
            "Gilgamesh", "Gilles de Rais", "Illyasviel von Einzbern", "Lancelot", "Leonardo da Vinci", "Medusa", "Oda Nobunaga", "Sessyoin Kiara",
            "Tomoe Gozen", "Yu Mei-ren")

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

open class OnSwipeTouchListener(context: Context?) : OnTouchListener {
    companion object {
        private const val SWIPE_DISTANCE_THRESHOLD = 100
        private const val SWIPE_VELOCITY_THRESHOLD = 100
    }

    private val gestureDetector: GestureDetector

    init {
        gestureDetector = GestureDetector(context, GestureListener())
    }

    open fun onSwipeLeft() {}
    fun onSwipeRight() {}
    override fun onTouch(v: View, event: MotionEvent): Boolean {
        return gestureDetector.onTouchEvent(event)
    }

    private inner class GestureListener : SimpleOnGestureListener() {
        override fun onDown(e: MotionEvent): Boolean {
            return true
        }

        override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
            val distanceX = e2.x - e1.x
            val distanceY = e2.y - e1.y
            if (abs(distanceX) > abs(distanceY) && abs(distanceX) > Companion.SWIPE_DISTANCE_THRESHOLD && abs(velocityX) > Companion.SWIPE_VELOCITY_THRESHOLD) {
                if (distanceX > 0) onSwipeRight() else onSwipeLeft()
                return true
            }
            return false
        }
    }
}