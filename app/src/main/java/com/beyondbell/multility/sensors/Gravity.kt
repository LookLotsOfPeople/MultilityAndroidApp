package com.beyondbell.multility.sensors

import android.annotation.SuppressLint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorManager
import com.beyondbell.multility.R
import kotlinx.android.synthetic.main.triple.*

class Gravity : SensorView() {
	override fun getSensor(sensorManager: SensorManager?): Sensor? {
		return sensorManager?.getDefaultSensor(Sensor.TYPE_GRAVITY)
	}

	override fun getSensorView(): Int {
		return R.layout.triple
	}

	@SuppressLint("SetTextI18n")
	override fun update(sensorEvent: SensorEvent) {
		first.text = sensorEvent.values[0].toString() + " m/s^2"
		second.text = sensorEvent.values[1].toString() + " m/s^2"
		third.text = sensorEvent.values[2].toString() + " m/s^2"
	}
}