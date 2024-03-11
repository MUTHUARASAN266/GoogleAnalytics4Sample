package com.example.googleanalytics4sample

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.analytics.GoogleAnalytics
import com.google.android.gms.analytics.HitBuilders
import com.google.android.gms.analytics.HitBuilders.ExceptionBuilder
import com.google.android.gms.analytics.HitBuilders.SocialBuilder
import com.google.android.gms.analytics.HitBuilders.TimingBuilder
import com.google.android.gms.analytics.Tracker


class HomeActivity : AppCompatActivity() {
    @SuppressLint("VisibleForTests")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        findViewById<TextView>(R.id.Home_text).setOnClickListener {
            startActivity(Intent(this@HomeActivity,TestScreen::class.java))
        }
        val analytics = GoogleAnalytics.getInstance(this)
        val tracker = analytics.newTracker("G-PJGK7H576M")
        tracker.enableAutoActivityTracking(true)

        val application: AnalyticsApplication = application as AnalyticsApplication
        val sTracker:Tracker? = application.getDefaultTracker()

        sTracker?.send(mapOf("button_click" to "loginSuccess"))
        sTracker?.setScreenName("GA4 Screen")
        sTracker?.send(HitBuilders.ScreenViewBuilder().build())
        // Send a screen view
        tracker.setScreenName("Screen Name Home Screen muhtu")
        tracker.send(HitBuilders.ScreenViewBuilder().build())

//        tracker.setScreenName("Screen Name Card Screen muhtuArasan")
//        tracker.send(HitBuilders.ScreenViewBuilder().set("screen_name_test", "100").build())

        tracker.send(
            TimingBuilder().setCategory("category").setLabel("label").setValue(5)
                .setVariable("variable").build()
        )
        tracker.send(ExceptionBuilder().setFatal(false).setDescription("description").build())
        tracker.send(
            SocialBuilder().setTarget("target").setNetwork("network").setAction("action").build()
        )

        /*
//
//        // Initialize the TagManager
//        // Initialize the TagManager
//        val tagManager = TagManager.getInstance(this)
//        // Load container with your GA4 Measurement ID
//        tagManager.setVerboseLoggingEnabled(true) // Enable verbose logging for debugging
//        val containerHolder: PendingResult<ContainerHolder> = tagManager.loadContainerPreferFresh(
//            "GTM-MZ8QFD4R",  // Replace with your GTM Container ID
//            R.raw.global_tracker   // Place your container JSON file in the "res/raw" folder
//        )
//        // Obtain a reference to the DataLayer
//        // Obtain a reference to the DataLayer
//        val dataLayer = TagManager.getInstance(this).dataLayer
//
//        // Example: Tracking a custom event
//        dataLayer.pushEvent("button_click", DataLayer.mapOf(
//            "event_category", "ui_interaction",
//            "event_action", "click",
//            "button_name", "login"
//        ));
*/

        // Send an event
        tracker.send(
            HitBuilders.EventBuilder().set("ga4_test1", "1").setCategory("Category")
                .setAction("Action").setLabel("Label").setCustomDimension(1, "Screen_Test_Value")
                .setValue(12126).build()
        )
        tracker.send(
            HitBuilders.ScreenViewBuilder().set("ga4_test2", "1").setCustomDimension(1, "Value 1")
                .setCustomDimension(2, "Value 2").build()
        )
        tracker.send(
            HitBuilders.EventBuilder().set("ga4_test3", "1").setCategory("Home")
                .setAction("click").setLabel("button").setCustomDimension(1, "Screen_Test_Value01")
                .setValue(12125).build()
        )
        tracker.send(mapOf("button_id" to "my_button"))

        GoogleAnalytics.getInstance(this).setDryRun(true)
        GoogleAnalytics.getInstance(this).dispatchLocalHits()

    }
}