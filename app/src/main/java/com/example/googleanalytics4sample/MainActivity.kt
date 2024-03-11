package com.example.googleanalytics4sample

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.googleanalytics4sample.databinding.ActivityMainBinding
import com.google.android.gms.analytics.GoogleAnalytics
import com.google.android.gms.analytics.HitBuilders.EventBuilder
import com.google.android.gms.analytics.HitBuilders.ItemBuilder
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder
import com.google.android.gms.analytics.Tracker
import com.google.android.gms.analytics.ecommerce.Product
import com.google.android.gms.analytics.ecommerce.ProductAction


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var sAnalytics: GoogleAnalytics? = null
    private var sTracker: Tracker? = null
    @SuppressLint("VisibleForTests")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sAnalytics = GoogleAnalytics.getInstance(this)

        binding.button.setOnClickListener {
            startActivity(Intent(this@MainActivity,HomeActivity::class.java))
        }
        val analytics = GoogleAnalytics.getInstance(this)
        // Create a 'global_tracker.xml' file in 'res/xml' folder
        val tracker = analytics.newTracker("G-PJGK7H576M")
        tracker.enableAutoActivityTracking(true)

        // Send a screen view
        tracker.setScreenName("Screen Name Arasan Muthu 12126")
        tracker.send(ScreenViewBuilder().build())

        tracker.setScreenName("Image~" + "name")
        tracker.send(ScreenViewBuilder().build())

        tracker.setTitle("myScreenMain")
        tracker.setScreenName("MyScreenName" + "Arasan")
        tracker.send(ScreenViewBuilder().build())
        tracker.enableAutoActivityTracking(true)
        // Send an event
        tracker.send(
            EventBuilder()
                .set("tracker_Test1","100")
                .setCategory("Category")
                .setAction("Action")
                .setLabel("Label")
                .setValue(1)
                .build()
        )
        tracker.send(
            ScreenViewBuilder()
                .set("tracker_Test2","1")
                .setCustomDimension(1, "Value 1")
                .setCustomDimension(2, "Value 2")
                .build()
        )
        tracker.send(
            ItemBuilder()
                .set("tracker_Test5","1")
                .setName("Hinata")
                .setCurrencyCode("+91")
                .setCategory("mobile")
                .setPrice(1000.0)
                .setQuantity(2)
                .setCustomDimension(1, "Value 1")
                .setCustomDimension(2, "Value 2")
                .build()
        )
        GoogleAnalytics.getInstance(this).setDryRun(true)

        val application: AnalyticsApplication = application as AnalyticsApplication
        sTracker = application.getDefaultTracker()
        sTracker?.setScreenName("Image~$ Mutharasan")
        sTracker?.send(ScreenViewBuilder().build())

        sTracker?.send(
            EventBuilder()
                .set("tracker_Test3","1")
                .setCategory("Action")
                .setAction("Share")
                .build()
        )


        val product = Product()
            .setId("1251")
            .setQuantity(3)
            .setName("Dragon Food")
            .setPrice(40.00)

        val productAction = ProductAction(ProductAction.ACTION_PURCHASE)
            .setTransactionId("T12345")

            // Add the transaction data to the event.
        val builder = EventBuilder()
            .set("tracker_product","1")
            .setCategory("In-Game Store")
            .setAction("Purchase")
            .addProduct(product)
            .setProductAction(productAction)

            // Send the transaction data with the event.

        sTracker?.send(builder.build())

        val googleAnalytics12 = GoogleAnalytics.getInstance(this@MainActivity)
        val tracker12: Tracker = googleAnalytics12.newTracker("G-PJGK7H576M")
        // Get tracker.
        tracker12.send(
            EventBuilder()
                .set("tracker_Test4","1")
                .setCategory("Category Name")
                .setAction("Action Name")
                .setLabel("Label Name")
                .setValue(100) // Optional: Event value
                .setCustomDimension(1, "Custom_Dimension_Value1")
                .build()
        )
        sTracker?.setScreenName("Home Screen")
        sTracker?.send(
            ScreenViewBuilder()
                .setCustomDimension(1, "premiumUser")
                .build()
        )
    }
}