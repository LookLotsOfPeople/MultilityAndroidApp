package com.beyondbell.multility

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.hardware.SensorManager
import android.os.Bundle
import com.beyondbell.multility.sensors.AvailableSensorsList
import com.beyondbell.multility.utilities.AvailableUtilitiesList

class LandingScreen : Activity() {
	private val setupThreads = ArrayList<Thread>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.landing)
		checkSensors()
		waitForSetup()
		openMainMenu()
	}

	private fun checkSensors() {
		AvailableSensorsList.sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
		AvailableSensorsList.list.clear()
		for (sensor in AvailableSensorsList.Sensor.values()) {
			if (sensor.check) {
				AvailableSensorsList.list.add(sensor)
				val setupThread = Thread {
					sensor.init
				}
				setupThreads.add(setupThread)
				setupThread.start()
			}
		}
		for (utility in AvailableUtilitiesList.list) {

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