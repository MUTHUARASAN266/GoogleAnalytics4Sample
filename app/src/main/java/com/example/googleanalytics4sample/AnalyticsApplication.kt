package com.example.googleanalytics4sample

import android.annotation.SuppressLint
import android.app.Application
import com.google.android.gms.analytics.GoogleAnalytics
import com.google.android.gms.analytics.Logger
import com.google.android.gms.analytics.Tracker

class AnalyticsApplication: Application() {

    private var sAnalytics: GoogleAnalytics? = null
    private var sTracker: Tracker? = null

    @SuppressLint("VisibleForTests")
    override fun onCreate() {
        super.onCreate()
        sAnalytics = GoogleAnalytics.getInstance(this@AnalyticsApplication)
        sAnalytics?.logger?.logLevel = Logger.LogLevel.INFO
        sAnalytics?.logger?.logLevel = Logger.LogLevel.VERBOSE
    }

    /**
     * Gets the default [Tracker] for this [Application].
     * @return tracker
     */
    @SuppressLint("VisibleForTests")
    @Synchronized
    fun getDefaultTracker(): Tracker? {
        // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
        if (sTracker == null) {
            sTracker = sAnalytics!!.newTracker(R.xml.global_tracker)
            sTracker?.enableAutoActivityTracking(true);
            sTracker?.enableExceptionReporting(true);
            sTracker?.setSessionTimeout(-1);
        }
        return sTracker
    }
}