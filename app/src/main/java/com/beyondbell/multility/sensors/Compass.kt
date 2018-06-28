package com.beyondbell.multility.sensors

import android.annotation.SuppressLint
import android.hardware.Sensor
import android.hardware.Sensor.TYPE_MAGNETIC_FIELD
import android.hardware.SensorEvent
import android.hardware.SensorManager
import com.beyondbell.multility.R

class Compass : SensorView() {
	override fun getSensor(sensorManager: SensorManager?): Sensor? {
		return sensorManager!!.getDefaultSensor(TYPE_MAGNETIC_FIELD)
	}

	override fun getSensorView(): Int {
		return R.layout.compass
	}

	@SuppressLint("SetTextI18n")
	override fun update(sensorEvent: SensorEvent) {
		// TODO Placeholder
	}
}
