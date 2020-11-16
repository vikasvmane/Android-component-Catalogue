package com.vikas.androidcomponentscatalogue.room.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(@PrimaryKey val title: String, val timer: String)