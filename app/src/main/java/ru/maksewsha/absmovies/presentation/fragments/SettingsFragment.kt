package ru.maksewsha.absmovies.presentation.fragments

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import ru.maksewsha.absmovies.R

class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings_layout, rootKey)
    }
}