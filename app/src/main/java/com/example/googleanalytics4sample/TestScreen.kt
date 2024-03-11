package com.example.googleanalytics4sample

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.analytics.GoogleAnalytics
import com.google.android.gms.analytics.HitBuilders
import com.google.android.gms.analytics.HitBuilders.AppViewBuilder
import com.google.android.gms.analytics.HitBuilders.EventBuilder
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder
import com.google.android.gms.analytics.Tracker
import com.google.firebase.analytics.FirebaseAnalytics


class TestScreen : AppCompatActivity() {
    var TAG="TestScreen"
     private var tracker: Tracker?=null
     private var mTracker: Tracker?=null
    @SuppressLint("VisibleForTests")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_screen)

        val application: AnalyticsApplication = application as AnalyticsApplication
         mTracker= application.getDefaultTracker()
        val analytics:GoogleAnalytics = GoogleAnalytics.getInstance(this)
         tracker= analytics.newTracker("G-PJGK7H576M")


        Log.e(TAG, "onCreate: mTracker")
        mTracker?.setScreenName("Home Screen")

        findViewById<Button>(R.id.btn_send_test).setOnClickListener {
            Log.e(TAG, "btn: click")

//            val bundle = Bundle()
//            bundle.putString("Test_value", "123")
//            bundle.putString("Screen_value", "1")
//            FirebaseAnalytics.getInstance(this@TestScreen).logEvent("event_name_muthu", bundle)

            mTracker?.setScreenName("Home Screen")
            mTracker?.send(
                HitBuilders.EventBuilder()
                    .set("Test1_Test1","100")
                    .setCategory("CategoryMuhtu")
                    .setCategory("CategoryMuhtu")
                    .setAction("ActionClick")
                    .setLabel("LabelAppName")
                    .setCustomDimension(1,"my_pref_1")
                    .setCustomDimension(2,"my_pref_1")
                    .setCustomDimension(3,"my_pref_1")
                    .setCustomDimension(4,"my_pref_2")
                    .setValue(1)
                    .build()
            )
            mTracker?.send(HitBuilders.ScreenViewBuilder().build())

        }
        mTracker?.send(
            HitBuilders.EventBuilder()
                .set("Test1_Test1","100")
                .setCategory("CategoryMuhtu")
                .setCategory("CategoryMuhtu")
                .setAction("ActionClick")
                .setLabel("LabelAppName")
                .setCustomDimension(1,"my_pref_1")
                .setCustomDimension(2,"my_pref_1")
                .setCustomDimension(3,"my_pref_1")
                .setCustomDimension(4,"my_pref_2")
                .setValue(1)
                .build()
        )
        GoogleAnalytics.getInstance(this).reportActivityStart(this)
        mTracker?.setScreenName("screenName")
        mTracker?.send(
            EventBuilder()
                .setCategory("Video")
                .setAction("Play")
                .setLabel("label")
                .setValue(1)
                .set("&geoid", "21137")
                .setCustomDimension(1,"my_video_pref")
                .build()
        )
        mTracker?.setScreenName("screenName premiumUser")
        mTracker?.send(
            ScreenViewBuilder()
                .setCustomDimension(1, "premiumUser")
                .build()
        )

        mTracker?.send(mapOf("button_click_test" to "loginSuccessTest"))
        mTracker?.setScreenName("TestScreen view")
        mTracker?.enableAutoActivityTracking(true)
        mTracker?.enableAdvertisingIdCollection(true)
        mTracker?.enableExceptionReporting(true)
        mTracker?.setAppName("GoogleAnalyticsGA4Sample")
        mTracker?.setAppVersion("0.1")
        mTracker?.setPage("TestScreenPage1")
        mTracker?.setTitle("GA4TestScreen")
        mTracker?.setUseSecure(true)
        mTracker?.send(HitBuilders.ScreenViewBuilder().build())
        mTracker?.send(AppViewBuilder().build())
//        GoogleAnalytics.getInstance(this).setDryRun(true)
        mTracker?.enableAutoActivityTracking(true)

        mTracker?.set("&user_type", "premium")
        GoogleAnalytics.getInstance(this).dispatchLocalHits()


   /*     val map: MutableMap<String, String> = HashMap()
        map["id"]="12125"
        Log.e(TAG, "onCreate: $map")


        val tracker123: Tracker = GoogleAnalytics.getInstance(this).newTracker("G-PJGK7H576M")
*/

        parametersValue("key1","value")

        val tracker: Tracker = GoogleAnalytics.getInstance(this).newTracker("G-PJGK7H576M")

        val hitParameters = HashMap<String, String>()
        hitParameters["&muthu_app_name"] = "appviewMuhtuTest"

        tracker.send(hitParameters)
        mTracker?.send(hitParameters)
    }

    @SuppressLint("VisibleForTests")
    private fun parametersValue(key: String, value: String) {
        val hitParameters = HashMap<String, String>()
        hitParameters[key]=value
        hitParameters[key]=value
        Log.e(TAG, "onCreate: ${hitParameters[key]}")
        Log.e(TAG, "onCreate: ${hitParameters[key]}")
//        mTracker?.send(hitParameters)
//        tracker?.send(hitParameters)
    }

    @SuppressLint("VisibleForTests")
    override fun onStart() {
        super.onStart()
        GoogleAnalytics.getInstance(this).reportActivityStart(this);
    }

    @SuppressLint("VisibleForTests")
    override fun onStop() {
        super.onStop()
        GoogleAnalytics.getInstance(this).reportActivityStop(this);
    }
}