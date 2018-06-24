package com.beyondbell.multility.sensors

object AvailableSensorsList {
    val list = ArrayList<Sensors>()

    enum class Sensors(check: Boolean, init: Unit) {
        Compass(compassCheck(), compassInit());

        val check = check
        val init = init
    }

    fun compassCheck() : Boolean {
        return true
    }

    fun compassInit() : Unit {
        return true
    }
}