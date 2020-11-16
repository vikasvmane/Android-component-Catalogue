package com.vikas.androidcomponentscatalogue.room.notesList

import androidx.recyclerview.widget.DiffUtil
import com.vikas.androidcomponentscatalogue.room.model.db.Note

class NotesDiffUtilsCallback : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note) =
        oldItem.title == newItem.title

    override fun areContentsTheSame(oldItem: Note, newItem: Note) =
        oldItem.title == newItem.title
}