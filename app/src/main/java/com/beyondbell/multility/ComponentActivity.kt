package com.beyondbell.multility

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.beyondbell.multility.sensors.*
import com.beyondbell.multility.settings.Settings


abstract class ComponentActivity : AppCompatActivity() {
	protected fun getPreferences(context: Context): SharedPreferences? {
		return PreferenceManager.getDefaultSharedPreferences(context)
	}


	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		val inflater = menuInflater
		inflater.inflate(R.menu.action_bar, menu)
		return true
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setupActionBar()
	}

	private fun setupActionBar() {
		val actionBar: ActionBar = supportActionBar!!
		actionBar.title = getString(R.string.app_name)
		actionBar.subtitle = getString(R.string.app_desc)
	}

	fun openSettings(menuItem: MenuItem?) {
		this@ComponentActivity.startActivity(Intent(this@ComponentActivity, Settings::class.java))
	}

	fun returnToMainMenu(menuItem: MenuItem?) {
		finish()
	}

	fun openAccelerometer(menuItem: MenuItem?) {
		this@ComponentActivity.startActivity(Intent(this@ComponentActivity, Accelerometer::class.java))
		finish()
	}

	fun openAmbientTemperature(menuItem: MenuItem?) {
		this@ComponentActivity.startActivity(Intent(this@ComponentActivity, AmbientTemperature::class.java))
		finish()
	}

	fun openGravity(menuItem: MenuItem?) {
		this@ComponentActivity.startActivity(Intent(this@ComponentActivity, Gravity::class.java))
		finish()
	}

	fun openGyroscope(menuItem: MenuItem?) {
		this@ComponentActivity.startActivity(Intent(this@ComponentActivity, Gyroscope::class.java))
		finish()
	}

	fun openLight(menuItem: MenuItem?) {
		this@ComponentActivity.startActivity(Intent(this@ComponentActivity, Light::class.java))
		finish()
	}
}