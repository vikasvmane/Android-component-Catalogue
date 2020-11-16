package com.vikas.androidcomponentscatalogue.alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import com.vikas.androidcomponentscatalogue.databinding.ActivityAlarmBinding

class AlarmActivity : AppCompatActivity() {
    lateinit var binding: ActivityAlarmBinding
    private lateinit var alarmManager: AlarmManager
    private lateinit var alarmIntent: PendingIntent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlarmBinding.inflate(layoutInflater)
        setContentView(binding.root)
        alarmManager =
            (getSystemService(Context.ALARM_SERVICE) as? AlarmManager)!!
        alarmIntent =
            PendingIntent.getBroadcast(
                this, ALARM_REQUEST_ID, Intent(this, AlarmReceiver::class.java),
                0
            )
        binding.toggleButton.setOnCheckedChangeListener { compoundButton, b ->
            if (b)
                setAlarm()
            else
                cancelAlarm()
        }
    }

    private fun setAlarm() {
        // Hopefully your alarm will have a lower frequency than this!
        alarmManager.set(
            AlarmManager.ELAPSED_REALTIME_WAKEUP,
            SystemClock.elapsedRealtime() + 10000,
            alarmIntent
        )
    }

    private fun cancelAlarm() {
        alarmManager.cancel(alarmIntent)
    }

    companion object {
        val ALARM_REQUEST_ID = 100
    }
}