package com.beyondbell.multility.utilities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.beyondbell.multility.R
import kotlinx.android.synthetic.main.calculator.*

class Calculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator)
        val bttn = button
        button.setOnClickListener {
            System.out.print("HELLO")
            Log.i("Calculator", "HELLO")
        }
    }
}