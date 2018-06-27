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
import com.beyondbell.multility.settings.Settings

abstract class ComponentActivity : AppCompatActivity() {
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

	fun openSensor(menuItem: MenuItem?) {

	}

	protected fun getPreferences(context: Context): SharedPreferences? {
		return PreferenceManager.getDefaultSharedPreferences(context)
	}
}