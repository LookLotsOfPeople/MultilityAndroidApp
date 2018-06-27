package com.beyondbell.multility.sensors

import android.annotation.SuppressLint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorManager
import android.widget.TextView

import com.beyondbell.multility.R

import android.hardware.Sensor.TYPE_MAGNETIC_FIELD

class Compass : SensorView() {
    override fun getSensor(sensorManager: SensorManager?): Sensor? {
        return sensorManager!!.getDefaultSensor(TYPE_MAGNETIC_FIELD)
    }

    override fun getSensorView(): Int {
        return R.layout.compass
    }

    @SuppressLint("SetTextI18n")
    override fun update(sensorEvent: SensorEvent?) {
        val tv1 = findViewById<TextView>(R.id.x3)
        val tv2 = findViewById<TextView>(R.id.x2)
        val average = sensorEvent!!.values[0]
        tv2.setText(average.toInt())
        when (average.toInt()) {
            0 -> {
                tv1.text = "North"
                tv1.text = "East"
                tv1.text = "South"
                tv1.text = "West"
            }
            90 -> {
                tv1.text = "East"
                tv1.text = "South"
                tv1.text = "West"
            }
            180 -> {
                tv1.text = "South"
                tv1.text = "West"
            }
            270 -> tv1.text = "West"
        }

        if (average.toInt() > 270 && average < 360) {
            tv1.text = "North West"
        } else if (average.toInt() > 180 && average < 270) {
            tv1.text = "South West"
        } else if (average.toInt() > 90 && average < 180) {
            tv1.text = "South East"
        } else if (average.toInt() > 0 && average < 90) {
            tv1.text = "North East"
        }
    }

    override fun init() {
        //TODO add <uses-feature/> in manifest.xml, voids use of extra method
    }
}
