package com.example.activityishaswindow

import android.view.View
import android.view.WindowManager

object WindowUtils {
    fun getWindowViews(params: String): ArrayList<View>? {
        try {
            val wmgClass =
                Class.forName("android.view.WindowManagerGlobal")
            val wmgInstnace =
                wmgClass.getMethod("getInstance").invoke(null)
            val mViewsField = wmgClass.getDeclaredField(params)
            mViewsField.isAccessible = true
            return mViewsField[wmgInstnace] as ArrayList<View>
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    fun getWindowParams(params: String): ArrayList<WindowManager.LayoutParams>? {
        try {
            val wmgClass =
                Class.forName("android.view.WindowManagerGlobal")
            val wmgInstnace =
                wmgClass.getMethod("getInstance").invoke(null)
            val mViewsField = wmgClass.getDeclaredField(params)
            mViewsField.isAccessible = true
            return mViewsField[wmgInstnace] as ArrayList<WindowManager.LayoutParams>
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}