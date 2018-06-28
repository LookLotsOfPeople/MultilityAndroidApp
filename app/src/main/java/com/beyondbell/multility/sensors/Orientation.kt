package com.beyondbell.multility.sensors

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorManager
import com.beyondbell.multility.R
import kotlinx.android.synthetic.main.triple.*

class Orientation : SensorView() {
	override fun getSensor(sensorManager: SensorManager?): Sensor? {
		return sensorManager?.getDefaultSensor(Sensor.TYPE_ORIENTATION)
	}

	override fun getSensorView(): Int {
		return R.layout.triple
	}

	override fun update(sensorEvent: SensorEvent) {
		first.text = sensorEvent.values[0].toString()
		second.text = sensorEvent.values[1].toString()
		third.text = sensorEvent.values[2].toString()
	}

	override fun getName(): String? {
		return "Orientation (Deprecated)"
	}
}