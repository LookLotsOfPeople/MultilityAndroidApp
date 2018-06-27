package com.beyondbell.multility.settings

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class Settings : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		supportFragmentManager.beginTransaction()
				.replace(android.R.id.content, Preferences())
				.commit()
	}
}