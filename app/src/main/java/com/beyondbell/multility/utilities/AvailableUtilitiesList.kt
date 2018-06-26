package com.beyondbell.multility.utilities

import android.content.Context
import android.content.Intent

object AvailableUtilitiesList {
    val list = ArrayList<Sensor>() //Sensor before, threw error in LandingScreen

    enum class Sensor(classInstance: IUtility) {
        Calculator(Calculator());

        val init = classInstance.init()
    }

    fun createIntent(packageContext: Context, sensor: Sensor): Intent {
        when (sensor) {
            AvailableUtilitiesList.Sensor.Calculator -> TODO()
        }
    }
}