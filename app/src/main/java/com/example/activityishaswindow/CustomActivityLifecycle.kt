package com.example.activityishaswindow

import android.app.Activity
import android.app.Application
import android.os.Bundle
import kotlin.collections.ArrayList


internal class CustomActivityLifecycle : Application.ActivityLifecycleCallbacks {

    private val mActivities = ArrayList<Activity>()

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        mActivities.add(activity)
    }

    override fun onActivityStarted(activity: Activity) {
    }

    override fun onActivityResumed(activity: Activity) {
    }

    override fun onActivityPaused(activity: Activity) {
    }

    override fun onActivityStopped(activity: Activity) {
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
    }

    override fun onActivityDestroyed(activity: Activity) {
        mActivities.remove(activity)
    }


    fun getActivities(): List<Activity> {
        return mActivities.toList()
    }
}