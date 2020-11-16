package com.vikas.androidcomponentscatalogue.daynight

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.vikas.androidcomponentscatalogue.databinding.ActivityDayNightBinding

class DayNightActivity : AppCompatActivity() {
    lateinit var binding: ActivityDayNightBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDayNightBinding.inflate(layoutInflater)
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_UNSPECIFIED) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            //Default set
            binding.textTitle.text = "Day"
        }
        setContentView(binding.root)
        binding.button.setOnClickListener {
            toggleDayNightMode()
        }
    }

    private fun toggleDayNightMode() {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO) {
            binding.textTitle.text = "Night"
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            binding.textTitle.text = "Day"
        }
    }
}