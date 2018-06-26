package com.beyondbell.multility.sensors

import android.content.Context
import android.content.Intent
import android.hardware.SensorManager

object AvailableSensorsList {
    val list = ArrayList<Sensor>()
    var sensorManager: SensorManager? = null

    enum class Sensor(classInstance: ISensor) {
        Gyroscope(Gyroscope());

        val check = classInstance.check(AvailableSensorsList.sensorManager!!)
        val init = classInstance.init()
    }

    fun createIntent(packageContext: Context, sensor: Sensor): Intent {
        when (sensor) {
            Sensor.Gyroscope -> {
                return Intent(packageContext, com.beyondbell.multility.sensors.Gyroscope::class.java)
            }
        }
    }
}