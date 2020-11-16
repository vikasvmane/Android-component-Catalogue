package com.vikas.androidcomponentscatalogue.settingsPref

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.vikas.androidcomponentscatalogue.R

class SettingsPrefFragment: PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preference,rootKey)
    }
}