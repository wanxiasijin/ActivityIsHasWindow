package com.example.activityishaswindow

object WindowUtils {
    fun <T> getWindowViews(params: String): ArrayList<T>? {
        try {
            val wmgClass = Class.forName("android.view.WindowManagerGlobal")
            val wmgInstance = wmgClass.getMethod("getInstance").invoke(null)
            val mViewsField = wmgClass.getDeclaredField(params)
            mViewsField.isAccessible = true
            return mViewsField[wmgInstance] as ArrayList<T>
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}