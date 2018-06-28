package com.beyondbell.multility

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.hardware.SensorManager
import android.os.Bundle
import android.preference.PreferenceManager
import com.beyondbell.multility.sensors.AvailableSensorsList

class LandingScreen : Activity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		checkSensors()
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
	}

	private fun openMainMenu() {
		this@LandingScreen.startActivity(Intent(this@LandingScreen, MainMenu::class.java))
		finish()
	}

	private fun defaultSettings() {
		PreferenceManager.setDefaultValues(this, R.xml.preferences, false)
	}
}