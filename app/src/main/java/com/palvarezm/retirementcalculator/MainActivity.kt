package com.palvarezm.retirementcalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import com.palvarezm.retirementcalculator.databinding.ActivityMainBinding
import java.lang.Exception
import java.util.*
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCenter.start(
            application, "592168ef-0e99-480d-b1f1-d1a5d5cef496",
            Analytics::class.java, Crashes::class.java
        )

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var time: String
        val properties = HashMap<String, String>()
        binding.btnThrowError.setOnClickListener {
            //Crashes.generateTestCrash()
            time = Date().toString()
            properties.put("Time: ", time)
            Analytics.trackEvent("Main button clicked", properties)
        }
    }
}