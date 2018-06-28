package com.beyondbell.multility.sensors

import android.annotation.SuppressLint
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorManager
import android.os.Build
import android.os.Bundle
import android.view.ViewStub
import android.widget.TextView
import com.beyondbell.multility.ComponentActivity
import com.beyondbell.multility.R
import com.beyondbell.multility.sensors.AvailableSensorsList.sensorManager
import kotlinx.android.synthetic.main.sensor.*

abstract class SensorView : ComponentActivity(), ISensor {

	@Volatile
	private var sensorEvent: SensorEvent? = null
	private var delay: Long = 0


	// Visuals Related
	abstract fun getSensorView(): Int

	// Sensor Related
	abstract fun getSensor(sensorManager: SensorManager?): Sensor?
	abstract fun update(sensorEvent: SensorEvent)


	// Sensor Stuff

	override fun check(sensorManager: SensorManager): Boolean {
		return getSensor(sensorManager) != null
	}

	override fun onSensorChanged(sensorEvent: SensorEvent?) {
		this.sensorEvent = sensorEvent
		updateRunnable.run()
	}

	private val updateRunnable = Runnable {
		val temp = sensorEvent
		if (temp != null) {
			update(temp)
		}
	}


	// Visuals Setup

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.sensor)
		setupVisuals()
		setupProperties()
		initSubview()
	}

	private fun setupVisuals() {
		sensorName.text = getName()
	}

	open fun getName(): String? {
		return this.javaClass.simpleName
	}

	@SuppressLint("SetTextI18n")
	private fun setupProperties() {
		val sensor = getSensor(sensorManager)

		if (sensor != null) {
			addProperty("Resolution: " + sensor.resolution)
			addProperty("Maximum Range: " + sensor.maximumRange)
			addProperty("Version: " + sensor.version)
			addProperty("Vendor: " + sensor.vendor)
			addProperty("Power: " + sensor.power)
		}
	}

	private fun addProperty(text: String) {
		val textView = TextView(this)
		textView.text = text
		textView.textSize = 24F
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
			textView.textAlignment = TextView.TEXT_ALIGNMENT_CENTER
		}
		propertiesLayout.addView(textView)
	}

	private fun initSubview() {
		val viewStub = ViewStub(this@SensorView, getSensorView())
		layout.addView(viewStub)
		viewStub.inflate()
	}


	// Conserves Battery By Registering and Unregistering the Sensor Based on Needs

	override fun onResume() {
		super.onResume()
		delay = getPreferences(this)?.getInt("delay", 100)!!.toLong()
		sensorManager?.registerListener(this, getSensor(sensorManager), delay.toInt())
	}

	override fun onPause() {
		super.onPause()
		val sensorManager: SensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
		sensorManager.unregisterListener(this)
	}


	// Unimplemented

	override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
}