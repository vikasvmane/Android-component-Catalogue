package com.vikas.androidcomponentscatalogue.room.notesList

import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vikas.androidcomponentscatalogue.databinding.RoomListItemBinding
import com.vikas.androidcomponentscatalogue.room.model.db.Note

class RoomListAdapter(private val listener: OnRecyclerViewItemClick) :
    ListAdapter<Note, RoomListViewHolder>(NotesDiffUtilsCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomListViewHolder {
        val view = RoomListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RoomListViewHolder(view)
    }

    override fun onBindViewHolder(holder: RoomListViewHolder, position: Int) {
        getItem(position)?.let { note ->
            holder.title.text = note.title
            holder.timer.text = note.timer
            holder.deleteIcon.setOnClickListener {
                listener.onClick(note)
            }
            holder.timer.setOnClickListener {
                holder.countDownTimer =
                    object : CountDownTimer(holder.timer.text.toString().toLong(), 1000) {
                        override fun onTick(p0: Long) {
                            holder.timer.text = "${p0 / 1000} Sec"
                        }

                        override fun onFinish() {
                            holder.timer.text = "Expired"
                        }
                    }
                holder.countDownTimer.start()
            }

        }
    }
}

class RoomListViewHolder(binding: RoomListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    lateinit var countDownTimer: CountDownTimer
    var title: TextView = binding.textTitle
    var timer: TextView = binding.textTimer
    var deleteIcon: ImageButton = binding.imageButton
}