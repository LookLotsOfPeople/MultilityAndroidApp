package com.beyondbell.multility.sensors

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorManager
import android.os.Bundle
import android.os.Handler
import android.view.ViewStub
import com.beyondbell.multility.ActionBarActivity
import com.beyondbell.multility.R
import com.beyondbell.multility.Settings
import com.beyondbell.multility.sensors.AvailableSensorsList.sensorManager
import kotlinx.android.synthetic.main.sensor.*

abstract class SensorView : ActionBarActivity(), ISensor {

    @Volatile private var sensorEvent : SensorEvent? = null

    // Visuals Related
    abstract fun getSensorView() : Int

    // Sensor Related
    abstract fun getSensor(sensorManager: SensorManager?): Sensor?
    abstract fun update(sensorEvent: SensorEvent?)


    // Sensor Stuff

    override fun check(sensorManager: SensorManager): Boolean {
	    return getSensor(sensorManager) != null
    }

    override fun onSensorChanged(sensorEvent: SensorEvent?) {
        this.sensorEvent = sensorEvent
    }


    // Sensor Timer

    private val handler : Handler = Handler()
    private var timer : Runnable? = null

    private fun setupTimer() {
        timer = Runnable {
            if (sensorEvent != null) {
                update(sensorEvent)
                handler.postDelayed(timer, Settings.updateInterval)
            } else {
                handler.post(timer)
            }
        }
    }


    // Visuals Setup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sensor)
        setupVisuals()
        initSubview()

        setupTimer()
    }

    private fun setupVisuals() {
        sensorName.text = this.javaClass.simpleName
    }

    private fun initSubview() {
        val viewStub = ViewStub(this@SensorView, getSensorView())
        layout.addView(viewStub)
        viewStub.inflate()
    }


    // Conserves Battery By Registering and Unregistering the Sensor Based on Needs

    override fun onResume() {
        super.onResume()
        sensorManager?.registerListener(this, getSensor(sensorManager), Settings.updateInterval.toInt())
        handler.post(timer)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(timer)
        val sensorManager: SensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManager.unregisterListener(this)
    }


    // Unimplemented

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
}