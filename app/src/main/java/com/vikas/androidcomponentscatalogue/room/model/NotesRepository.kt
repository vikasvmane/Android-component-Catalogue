package com.vikas.androidcomponentscatalogue.room.model

import androidx.lifecycle.LiveData
import com.vikas.androidcomponentscatalogue.room.model.db.Note
import com.vikas.androidcomponentscatalogue.room.model.db.NotesDao

class NotesRepository(private val notesDao: NotesDao) : NotesRepositoryContract {
    override fun getNotesList(): LiveData<List<Note>> {
        return notesDao.getNotes()
    }

    override suspend fun insertNote(note: Note) {
        return notesDao.insertAll(note)
    }

    override suspend fun deleteNote(note: Note) {
        return notesDao.delete(note)
    }
}