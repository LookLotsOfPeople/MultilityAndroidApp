package com.beyondbell.multility.sensors

import android.annotation.SuppressLint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorManager
import com.beyondbell.multility.R
import kotlinx.android.synthetic.main.two.*

class AmbientTemperature : SensorView() {
	override fun getSensor(sensorManager: SensorManager?): Sensor? {
		return sensorManager?.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)
	}

	override fun getSensorView(): Int {
		return R.layout.two
	}

	@SuppressLint("SetTextI18n")
	override fun update(sensorEvent: SensorEvent) {
		top.text = sensorEvent.values[0].toString() + " C"
		bottom.text = (sensorEvent.values[0] * 9/5 + 32).toString() + " F"
	}

	override fun getName() : String {
		return "Ambient Temperature"
	}
}