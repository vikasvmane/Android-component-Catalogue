package com.vikas.androidcomponentscatalogue.room.model

import androidx.lifecycle.LiveData
import com.vikas.androidcomponentscatalogue.room.model.db.Note

interface NotesRepositoryContract {
    fun getNotesList(): LiveData<List<Note>>
    suspend fun insertNote(note: Note)
    suspend fun deleteNote(note: Note)
}