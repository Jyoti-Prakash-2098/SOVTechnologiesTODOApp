package com.example.sovtechnologies.ui.recyclerviewadapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.sovtechnologies.R
import com.example.sovtechnologies.databinding.TodoItemBinding
import com.example.sovtechnologies.ui.db.Tasks

class TodoRecyclerViewAdapter(private val list: MutableList<Tasks>) : RecyclerView.Adapter<TodoRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(private val todoBinding: TodoItemBinding) : RecyclerView.ViewHolder(todoBinding.root) {
        fun setData(tasks: Tasks) {
            todoBinding.taskHeader.text = String.format("%s",tasks.title)
            todoBinding.taskDetails.text = String.format("%s",tasks.description)
            todoBinding.viewMain.setBackgroundColor(Color.parseColor(tasks.priorityColor))
            if (tasks.status.equals("pending",true)){
                todoBinding.taskHeader.setTextColor(Color.BLACK)
                todoBinding.viewTaskHeader.visibility = View.GONE
            } else {
                todoBinding.taskHeader.setTextColor(ContextCompat.getColor(todoBinding.root.context,
                    R.color.grey))
                todoBinding.viewTaskHeader.visibility = View.VISIBLE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            TodoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(list[position])
    }
}