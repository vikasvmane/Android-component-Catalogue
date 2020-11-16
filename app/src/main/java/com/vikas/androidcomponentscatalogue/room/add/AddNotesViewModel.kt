package com.vikas.androidcomponentscatalogue.room.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.vikas.androidcomponentscatalogue.room.model.NotesRepository
import com.vikas.androidcomponentscatalogue.room.model.db.Note
import kotlinx.coroutines.launch

class AddNotesViewModel(private val repository: NotesRepository) : ViewModel() {
    fun insertNote(note: Note){
        viewModelScope.launch {
            repository.insertNote(note)
        }
    }
}

class AddNotesViewModelFactory(private val repository: NotesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddNotesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AddNotesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}