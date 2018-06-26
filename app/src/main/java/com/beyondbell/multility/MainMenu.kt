package com.beyondbell.multility

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import com.beyondbell.multility.sensors.AvailableSensorsList
import kotlinx.android.synthetic.main.main_menu.*

class MainMenu : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu)
        createButtons()
    }

    private fun createButtons() {
        val componentsList = componentsList
        for (sensor in AvailableSensorsList.list) {
            componentsList.addView(createButton(sensor))
        }
    }

    private fun createButton(sensor: AvailableSensorsList.Sensor): Button {
        val button = Button(this)
        button.text = sensor.name
        button.setOnClickListener {
            this@MainMenu.startActivity(AvailableSensorsList.createIntent(this@MainMenu, sensor))
        }
        return button
    }
}