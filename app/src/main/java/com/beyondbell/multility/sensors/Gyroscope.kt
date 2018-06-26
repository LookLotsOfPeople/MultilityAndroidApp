package com.beyondbell.multility.sensors

import android.annotation.SuppressLint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorManager
import com.beyondbell.multility.R
import kotlinx.android.synthetic.main.xyz.*

class Gyroscope : SensorView() {

    // Sensor

    override fun init() {
        // TODO Check for Permission to Use Sensor
    }

    override fun getSensor(sensorManager: SensorManager?): Sensor? {
        return sensorManager?.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
    }


    @SuppressLint("SetTextI18n")
    override fun update(sensorEvent: SensorEvent?) {
        if (sensorEvent != null) {
            x.text = "X: " + Math.toDegrees(sensorEvent.values[0].toDouble()).toString()
            y.text = "Y: " + Math.toDegrees(sensorEvent.values[1].toDouble()).toString()
            z.text = "Z: " + Math.toDegrees(sensorEvent.values[2].toDouble()).toString()
        } else {
            x.text = "X: " + getString(R.string.loading)
            x.text = "Y: " + getString(R.string.loading)
            x.text = "Z: " + getString(R.string.loading)
        }
    }


    // Visual

    override fun getSensorName(): String {
        return "Gyroscope"
    }

    override fun getSensorView(): Int {
        return R.layout.xyz
    }
}