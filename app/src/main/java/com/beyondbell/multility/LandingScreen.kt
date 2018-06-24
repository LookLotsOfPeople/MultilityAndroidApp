package com.beyondbell.multility

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.beyondbell.multility.sensors.AvailableSensorsList

class LandingScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.landing)
        checkSensors()
        openMainMenu()
    }

    private fun checkSensors() {
        for (sensor in AvailableSensorsList.Sensors.values()) {
            if (true /*Has Sensor*/) {
                AvailableSensorsList.list.add(sensor)
                Runnable {
                    loadModule(sensor)
                }.run()
            }
        }
    }

    private fun loadModule(sensors: AvailableSensorsList.Sensors) {
        // TODO Any Pre-Loading
    }

    private fun openMainMenu() {

    }
}