package com.vikas.androidcomponentscatalogue.room.notesList

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.vikas.androidcomponentscatalogue.room.model.NotesRepository
import com.vikas.androidcomponentscatalogue.room.model.db.Note
import kotlinx.coroutines.launch

class NotesListViewModel(private val repository: NotesRepository) : ViewModel() {
    var notesList: LiveData<List<Note>> = repository.getNotesList()

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            repository.deleteNote(note)
        }
    }
}

class WordViewModelFactory(private val repository: NotesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NotesListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NotesListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}