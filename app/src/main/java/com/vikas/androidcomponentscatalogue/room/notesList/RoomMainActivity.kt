package com.vikas.androidcomponentscatalogue.room.notesList

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.vikas.androidcomponentscatalogue.databinding.ActivityRoomMainBinding
import com.vikas.androidcomponentscatalogue.room.model.NotesRepository
import com.vikas.androidcomponentscatalogue.room.add.AddNotesActivity
import com.vikas.androidcomponentscatalogue.room.model.db.AppDatabase
import com.vikas.androidcomponentscatalogue.room.model.db.Note


class RoomMainActivity : AppCompatActivity() {
    lateinit var roomMainBinding: ActivityRoomMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        roomMainBinding = ActivityRoomMainBinding.inflate(layoutInflater)
        setContentView(roomMainBinding.root)
        val viewModel: NotesListViewModel by viewModels {
            WordViewModelFactory(
                repository = NotesRepository(
                    AppDatabase.getDatabase(this).noteDao()
                )
            )
        }
        val adapter = RoomListAdapter(object : OnRecyclerViewItemClick{
            override fun onClick(note: Note) {
                viewModel.deleteNote(note)
            }
        })
        viewModel.notesList.observe(this) { list -> adapter.submitList(list) }
        roomMainBinding.recyclerView.adapter = adapter
        roomMainBinding.floatingActionButton.setOnClickListener {
            startActivity(Intent(this, AddNotesActivity::class.java))
        }
    }
}
interface OnRecyclerViewItemClick{
    fun onClick(note: Note)
}