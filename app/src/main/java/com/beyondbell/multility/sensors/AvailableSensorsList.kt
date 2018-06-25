package com.beyondbell.multility.sensors

import android.hardware.Sensor

object AvailableSensorsList {
    val list = ArrayList<Sensors>() //Sensor before, threw error in LandingScreen

    enum class Sensors(val check: Boolean, val init: Unit)
}