package com.beyondbell.multility.sensors

import android.content.Context
import android.content.Intent
import android.hardware.SensorManager

object AvailableSensorsList {
	val list = ArrayList<Sensor>()
	var sensorManager: SensorManager? = null

	enum class Sensor(classInstance: ISensor) {
		Accelerometer(Accelerometer()), AmbientTemperature(AmbientTemperature()), Gravity(Gravity()),
		Gyroscope(Gyroscope()), Light(Light()),
		Compass(Compass());

		val check = classInstance.check(AvailableSensorsList.sensorManager!!)
	}

	fun createIntent(packageContext: Context, sensor: Sensor): Intent {
		return when (sensor) {
			Sensor.Accelerometer -> { Intent(packageContext, com.beyondbell.multility.sensors.Accelerometer::class.java) }
			Sensor.AmbientTemperature -> { Intent(packageContext, com.beyondbell.multility.sensors.AmbientTemperature::class.java) }
			Sensor.Gravity -> { Intent(packageContext, com.beyondbell.multility.sensors.Gravity::class.java) }
			Sensor.Gyroscope -> { Intent(packageContext, com.beyondbell.multility.sensors.Gyroscope::class.java) }
			Sensor.Light -> { Intent(packageContext, com.beyondbell.multility.sensors.Light::class.java) }
			Sensor.Compass -> { Intent(packageContext, com.beyondbell.multility.sensors.Compass::class.java) }
		}
	}
}