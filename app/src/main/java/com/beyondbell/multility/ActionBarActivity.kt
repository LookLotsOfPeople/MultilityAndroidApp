package com.beyondbell.multility

import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

abstract class ActionBarActivity : AppCompatActivity() {
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

	fun openOptions(menuItem: MenuItem?) {

	}

	fun quitApplication(menuItem: MenuItem?) {
		finishAndRemoveTask()
	}

	fun openSensor(menuItem: MenuItem?) {

	}
}