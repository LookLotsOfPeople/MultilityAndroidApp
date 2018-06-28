package com.beyondbell.multility.settings

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.beyondbell.multility.R

class Settings : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		actionBar.subtitle = getString(R.string.settings)
		supportFragmentManager.beginTransaction()
				.replace(android.R.id.content, Preferences())
				.commit()
	}
}