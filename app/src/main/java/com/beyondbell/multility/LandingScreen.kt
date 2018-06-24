package com.beyondbell.multility

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.beyondbell.multility.sensors.AvailableSensorsList

class LandingScreen : AppCompatActivity() {
    private val setupThreads = ArrayList<Thread>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.landing)
        checkSensors()
        waitForSetup()
        openMainMenu()
    }

    private fun checkSensors() {
        for (sensor in AvailableSensorsList.Sensors.values()) {
            if (sensor.check) {
                AvailableSensorsList.list.add(sensor)
                val setupThread = Thread(sensor::init)
                setupThreads.add(setupThread)
                setupThread.start()
            }
        }
    }

    private fun waitForSetup() {
        for (setupThread in setupThreads) {
            setupThread.join()
        }
    }

    private fun openMainMenu() {
        this@LandingScreen.startActivity(Intent(this@LandingScreen, MainMenu::class.java))
    }
}