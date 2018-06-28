package com.beyondbell.multility.sensors

import android.annotation.SuppressLint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorManager
import com.beyondbell.multility.R
import kotlinx.android.synthetic.main.triple.*

class Accelerometer : SensorView() {
	override fun getSensor(sensorManager: SensorManager?): Sensor? {
		return sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
	}

	override fun getSensorView(): Int {
		return R.layout.triple
	}

	@SuppressLint("SetTextI18n")
	override fun update(sensorEvent: SensorEvent?) {
		if (sensorEvent != null) {
			first.text = "X: " + sensorEvent.values[0].toString() + "m/s^2"
			second.text = "Y: " + sensorEvent.values[1].toString() + "m/s^2"
			third.text = "Z: " + sensorEvent.values[2].toString() + "m/s^2"
		} else {
			first.text = "X: " + getString(R.string.loading)
			first.text = "Y: " + getString(R.string.loading)
			first.text = "Z: " + getString(R.string.loading)
		}
	}
}