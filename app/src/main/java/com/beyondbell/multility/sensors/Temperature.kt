package com.beyondbell.multility.sensors

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorManager
import com.beyondbell.multility.R
import kotlinx.android.synthetic.main.single.*

class Temperature : SensorView() {
	override fun getSensor(sensorManager: SensorManager?): Sensor? {
		return sensorManager?.getDefaultSensor(Sensor.TYPE_TEMPERATURE)
	}

	override fun getSensorView(): Int {
		return R.layout.single
	}

	override fun update(sensorEvent: SensorEvent) {
		text.text = sensorEvent.values[0].toString()
	}

	override fun getName(): String? {
		return "Temperature (Deprecated)"
	}
}