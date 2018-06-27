package com.beyondbell.multility.settings

import android.os.Bundle
import android.support.v7.preference.PreferenceFragmentCompat
import com.beyondbell.multility.R

class Preferences : PreferenceFragmentCompat() {
	override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
		addPreferencesFromResource(R.xml.preferences)
	}
}