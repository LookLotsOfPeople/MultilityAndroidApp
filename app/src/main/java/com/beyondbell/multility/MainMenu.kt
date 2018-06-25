package com.beyondbell.multility

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

import android.widget.Button
import android.widget.LinearLayout



class MainMenu : AppCompatActivity() {
    val list = ArrayList<Button>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu)
    }

    fun createButton(sensorName: String) {
        val ll = findViewById(R.id.Layout) as LinearLayout
        val lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        val x = Button(this)
        x.setOnClickListener(clickListener)
        ll.addView(x, lp)
        list.add(x)
    }

    val clickListener = View.OnClickListener {view ->

        when (view.getId()) {
            //R.main_menu.textview -> fun()
            TODO("Assign functions to each instance of the button")
            //R.main_menu.button -> sFun()
        }
    }
}