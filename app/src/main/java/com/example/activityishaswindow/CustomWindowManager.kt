package com.example.activityishaswindow

import android.app.Activity
import android.app.Application

object CustomWindowManager {
    private val activityLifecycle by lazy {
        CustomActivityLifecycle()
    }

    fun init(application: Application) {
        application.registerActivityLifecycleCallbacks(activityLifecycle)

    }

    fun getWindowViewByToken(activity: Activity): Boolean?{
        //获取需要判断的Activity的decorView
        val targetDecorView=activity.window.decorView
        /**
         * 获取需要判断的Activity的子窗口的token,可以见android.view.Window#adjustLayoutParamsForSubWindow的
         wp.token子窗口赋值的那一段逻辑。
         */
        val targetSubToken=targetDecorView.windowToken
        //可见android.view.WindowManagerGlobal的mViews属性
        val mViews=WindowUtils.getWindowViews ("mViews")
        //根据mView集合和需要判断的Activity的decorView找到index位置
        val targetIndex=mViews?.indexOfFirst { it==targetDecorView }
        // 获取 mParams 集合 //可见android.view.WindowManagerGlobal的mParams属性
        val mParams = WindowUtils.getWindowParams("mParams")
        //获取应用窗口的token
        val targetToken = targetIndex?.let { mParams?.get(it)?.token }
        //遍历判断，不包含需要判断的Activity，如果有其他窗口出现，就说明有弹窗
        return mParams?.map {
            it.token
        }?.filter {
            it==null||it==targetSubToken||it==targetToken
        }?.size!! >1
    }

}