package com.beyondbell.multility.sensors

import android.annotation.SuppressLint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorManager
import com.beyondbell.multility.R
import kotlinx.android.synthetic.main.single.*

class Light : SensorView() {
	override fun getSensor(sensorManager: SensorManager?): Sensor? {
		return sensorManager?.getDefaultSensor(Sensor.TYPE_LIGHT)
	}

	override fun getSensorView(): Int {
		return R.layout.single
	}

	@SuppressLint("SetTextI18n")
	override fun update(sensorEvent: SensorEvent) {
		text.text = sensorEvent.values[0].toString() + " lx"
	}
}