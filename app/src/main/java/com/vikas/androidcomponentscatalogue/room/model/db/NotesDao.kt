package com.vikas.androidcomponentscatalogue.room.model.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NotesDao {
    @Query("SELECT * FROM note")
    fun getNotes(): LiveData<List<Note>>

    @Insert
    suspend fun insertAll(vararg users: Note)

    @Delete
    suspend fun delete(user: Note)
}