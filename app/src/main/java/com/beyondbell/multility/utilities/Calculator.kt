package com.beyondbell.multility.utilities

import android.os.Bundle
import com.beyondbell.multility.R

class Calculator : Utility(), IUtility {
    override fun init() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator)
    }
}