package com.beyondbell.multility.sensors

import android.hardware.SensorEventListener
import android.hardware.SensorManager

interface ISensor : SensorEventListener {
	fun check(sensorManager: SensorManager): Boolean
	fun init()
}