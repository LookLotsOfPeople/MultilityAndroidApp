package com.beyondbell.multility.sensors

import android.content.Context
import android.content.Intent
import android.hardware.SensorManager

object AvailableSensorsList {
	val list = ArrayList<Sensor>()
	var sensorManager: SensorManager? = null

	enum class Sensor(classInstance: ISensor) {
		Accelerometer(Accelerometer()), AmbientTemperature(AmbientTemperature()), Gravity(Gravity()),
		Gyroscope(Gyroscope()), Light(Light()), LinearAcceleration(LinearAcceleration()), Compass(Compass()),
		Orientation(Orientation()), Pressure(Pressure()), Proximity(Proximity()),
		RelativeHumidity(RelativeHumidity()), RotationVector(RotationVector()), Temperature(Temperature());

		val check = classInstance.check(AvailableSensorsList.sensorManager!!)
	}

	fun createIntent(packageContext: Context, sensor: Sensor): Intent {
		return when (sensor) {
			Sensor.Accelerometer -> { Intent(packageContext, Accelerometer::class.java) }
			Sensor.AmbientTemperature -> { Intent(packageContext, AmbientTemperature::class.java) }
			Sensor.Gravity -> { Intent(packageContext, Gravity::class.java) }
			Sensor.Gyroscope -> { Intent(packageContext, Gyroscope::class.java) }
			Sensor.Light -> { Intent(packageContext, Light::class.java) }
			Sensor.LinearAcceleration -> { Intent(packageContext, LinearAcceleration::class.java) }
			Sensor.Compass -> { Intent(packageContext, Compass::class.java) }
			Sensor.Orientation -> { Intent(packageContext, Orientation::class.java) }
			Sensor.Pressure -> { Intent(packageContext, Pressure::class.java) }
			Sensor.Proximity -> { Intent(packageContext, Proximity::class.java) }
			Sensor.RelativeHumidity -> { Intent(packageContext, RelativeHumidity::class.java) }
			Sensor.RotationVector -> { Intent(packageContext, RotationVector::class.java) }
			Sensor.Temperature -> { Intent(packageContext, Temperature::class.java) }
		}
	}
}