package com.vikas.androidcomponentscatalogue.room.add

import android.app.TimePickerDialog
import android.os.Build
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.vikas.androidcomponentscatalogue.databinding.ActivityAddNotesBinding
import com.vikas.androidcomponentscatalogue.room.model.NotesRepository
import com.vikas.androidcomponentscatalogue.room.model.db.AppDatabase
import com.vikas.androidcomponentscatalogue.room.model.db.Note
import java.text.SimpleDateFormat
import java.time.LocalTime
import java.util.*

class AddNotesActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddNotesBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel: AddNotesViewModel by viewModels {
            AddNotesViewModelFactory(
                repository = NotesRepository(
                    AppDatabase.getDatabase(this).noteDao()
                )
            )
        }
        binding.buttonSubmit.setOnClickListener {
            if (!binding.editTextTextMultiLine.text.toString()
                    .isNullOrBlank() && !binding.textTimer.text.toString().isNullOrBlank()
            ) {
                val localDateTime =
                    LocalTime.parse(binding.textTimer.text.toString())
                val millis: Int = localDateTime.toSecondOfDay() * 1000
                viewModel.insertNote(
                    Note(
                        title = binding.editTextTextMultiLine.text.toString(),
                        timer = "$millis"
                    )
                )
                finish()
            }
        }
        binding.textTimerLabel.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                binding.textTimer.text = "${SimpleDateFormat("HH:mm:ss").format(cal.time)}"
            }
            TimePickerDialog(
                this,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }
    }
}