package com.beyondbell.multility.sensors

import android.annotation.SuppressLint
import android.hardware.Sensor
import android.hardware.Sensor.TYPE_GYROSCOPE
import android.hardware.SensorEvent
import android.hardware.SensorManager
import com.beyondbell.multility.R
import kotlinx.android.synthetic.main.triple.*

class Gyroscope : SensorView() {
	override fun getSensor(sensorManager: SensorManager?): Sensor? {
		return sensorManager?.getDefaultSensor(TYPE_GYROSCOPE)
	}

	override fun getSensorView(): Int {
		return R.layout.triple
	}

	@SuppressLint("SetTextI18n")
	override fun update(sensorEvent: SensorEvent?) {
		if (sensorEvent != null) {
			first.text = "X: " + Math.toDegrees(sensorEvent.values[0].toDouble()).toString()
			second.text = "Y: " + Math.toDegrees(sensorEvent.values[1].toDouble()).toString()
			third.text = "Z: " + Math.toDegrees(sensorEvent.values[2].toDouble()).toString()
		} else {
			first.text = "X: " + getString(R.string.loading)
			first.text = "Y: " + getString(R.string.loading)
			first.text = "Z: " + getString(R.string.loading)
		}
	}
}