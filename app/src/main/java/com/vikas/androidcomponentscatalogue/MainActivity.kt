package com.vikas.androidcomponentscatalogue

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.vikas.androidcomponentscatalogue.alarm.AlarmActivity
import com.vikas.androidcomponentscatalogue.customview.CustomViewActivity
import com.vikas.androidcomponentscatalogue.databinding.ActivityMainBinding
import com.vikas.androidcomponentscatalogue.daynight.DayNightActivity
import com.vikas.androidcomponentscatalogue.room.notesList.RoomMainActivity
import com.vikas.androidcomponentscatalogue.settingsPref.SettingsPrefActivity


class MainActivity : AppCompatActivity(), RecyclerViewOnClick {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize view binding for view object references
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = MainRecyclerViewAdapter(
            resources.getStringArray(R.array.mainItems).toList() as ArrayList<String>, this
        )
        binding.mainRecyclerView.adapter = adapter
    }

    override fun onItemClick(selected: String) {
        log(selected)
        when (selected) {
            DAYNIGHT -> {
                startActivity(Intent(this, DayNightActivity::class.java))
            }
            SETTING_PREFERENCE -> startActivity(Intent(this, SettingsPrefActivity::class.java))
            COROUTINES -> log(selected)
            ROOM ->
                startActivity(Intent(this, RoomMainActivity::class.java))
            CUSTOMVIEW ->
                startActivity(Intent(this, CustomViewActivity::class.java))
            ALARM -> startActivity(Intent(this, AlarmActivity::class.java))
        }
    }


    companion object {
        const val DAYNIGHT = "Day/Night"
        const val SETTING_PREFERENCE = "Settings Preference"
        const val COROUTINES = "Coroutines"
        const val ROOM = "Room"
        const val CUSTOMVIEW = "Custom View"
        const val ALARM = "Alarm"
    }

    private fun log(data: String) {
        Log.i("Components", data)
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show()
    }

}