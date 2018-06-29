package com.beyondbell.multility.sensors

import android.annotation.SuppressLint
import android.hardware.Sensor
import android.hardware.Sensor.TYPE_MAGNETIC_FIELD
import android.hardware.SensorEvent
import android.hardware.SensorManager
import com.beyondbell.multility.R
import com.beyondbell.multility.R.id.x2
import com.beyondbell.multility.R.id.x3

class Compass : SensorView() {
	override fun getSensor(sensorManager: SensorManager?): Sensor? {
		return sensorManager!!.getDefaultSensor(TYPE_MAGNETIC_FIELD)
	}

	override fun getSensorView(): Int {
		return R.layout.compass
	}

	@SuppressLint("SetTextI18n")
	override fun update(sensorEvent: SensorEvent) {
		x2.text = sensorEvent.values[0].toString()
		if(sensorEvent.values[0] in 85..95) {
			x3.text = "West"
		} else if(sensorEvent.values[0] in 175.0..185.0) {
			x3.text = "South"
		} else if(sensorEvent.values[0] in 265.0..275.0) {
			x3.text = "East"
		} else if(sensorEvent.values[0] >= 355 || sensorEvent.values[0] <= 5) {
			x3.text = "North"
		} else if (sensorEvent.values[0].toInt() > 275 && sensorEvent.values[0] < 355) {
			x3.text = "North West"
		} else if (sensorEvent.values[0].toInt() > 185 && sensorEvent.values[0] < 265) {
			x3.text = "South West"
		} else if (sensorEvent.values[0].toInt() > 95 && sensorEvent.values[0] < 175) {
			x3.text = "South East"
		} else if (sensorEvent.values[0].toInt() > 5 && sensorEvent.values[0] < 85) {
			x3.text = "North East"
	}
}
