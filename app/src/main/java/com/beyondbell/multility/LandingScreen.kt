package com.beyondbell.multility

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.hardware.SensorManager
import android.os.Bundle
import android.preference.PreferenceManager
import com.beyondbell.multility.sensors.AvailableSensorsList
import com.beyondbell.multility.utilities.AvailableUtilitiesList

class LandingScreen : Activity() {
	private val setupThreads = ArrayList<Thread>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		checkSensors()
		waitForSetup()
		defaultSettings()
		openMainMenu()
	}

	private fun checkSensors() {
		AvailableSensorsList.sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
		AvailableSensorsList.list.clear()
		for (sensor in AvailableSensorsList.Sensor.values()) {
			if (sensor.check) {
				AvailableSensorsList.list.add(sensor)
			}
		}
		for (utility in AvailableUtilitiesList.list) {

		}
	}

	private fun waitForSetup() {
		/*
			val setupThread = Thread {
				sensor.init
			}
			setupThreads.add(setupThread)
			setupThread.start()

		 */
		for (setupThread in setupThreads) {
			setupThread.join()
		}
	}

	private fun openMainMenu() {
		this@LandingScreen.startActivity(Intent(this@LandingScreen, MainMenu::class.java))
		finish()
	}

	private fun defaultSettings() {
		PreferenceManager.setDefaultValues(this, R.xml.preferences, false)
	}
}