package com.vikas.androidcomponentscatalogue.settingsPref

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager
import com.vikas.androidcomponentscatalogue.R
import com.vikas.androidcomponentscatalogue.databinding.ActivitySettingsPrefBinding


class SettingsPrefActivity : AppCompatActivity(),
    PreferenceFragmentCompat.OnPreferenceStartFragmentCallback,
    SharedPreferences.OnSharedPreferenceChangeListener {
    lateinit var binding: ActivitySettingsPrefBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsPrefBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().add(R.id.container, SettingsPrefFragment())
            .commit()
        setupSharedPreferences()
    }

    private fun setupSharedPreferences() {
        val sharedPreferences: SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(this)
        sharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onPreferenceStartFragment(
        caller: PreferenceFragmentCompat?,
        pref: Preference?
    ): Boolean {
        return true
    }

    override fun onSharedPreferenceChanged(p0: SharedPreferences?, p1: String?) {
        if (p1.equals("sync")) {
            if (p0?.getBoolean("sync", true) == true) {
                Toast.makeText(this, "Sync is On", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Sync is Off", Toast.LENGTH_SHORT).show()
            }
        } else if (p1.equals("attachment")) {
            if (p0?.getBoolean("attachment", true) == true) {
                Toast.makeText(this, "Attachment is On", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Attachment is Off", Toast.LENGTH_SHORT).show()
            }
        }
    }
}