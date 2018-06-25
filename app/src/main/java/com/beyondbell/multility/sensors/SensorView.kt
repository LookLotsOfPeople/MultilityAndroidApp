package com.beyondbell.multility.sensors

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.beyondbell.multility.R
import kotlinx.android.synthetic.main.sensor.*

abstract class SensorView : AppCompatActivity() {
    abstract fun getSensorName() : String
    abstract fun getSensorView() : View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sensor)

        setupVisuals()
        initSubview()
    }

    private fun setupVisuals() {
        sensorName.text = getSensorName()
    }

    private fun initSubview() {
        getSensorView()
    }
}