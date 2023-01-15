package com.example.sovtechnologies.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sovtechnologies.ui.db.Tasks
import com.example.sovtechnologies.ui.db.TasksDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(private val db: TasksDatabase) : ViewModel() {
    fun getTasks() = db.getTasksDao().getNotesLive()

    private fun addTask(task: Tasks) {
        viewModelScope.launch(Dispatchers.IO) {
            db.getTasksDao().addTask(task)
        }
    }

    fun checkData() {
        viewModelScope.launch(Dispatchers.IO) {
            if (db.getTasksDao().getNotes().isEmpty()) {
                addTask(Tasks("Morning walk", "go for morning walk", "done", "#FF0000"))
                addTask(Tasks("Break Fast", "eat healthy", "done", "#FF0000"))
                addTask(Tasks("Buy Grocery", "Buy eggs", "pending", "#FFFF00"))
                addTask(Tasks("Play Games", "", "pending", "#0000FF"))
                addTask(Tasks("Study", "study maths", "pending", "#FF0000"))
            }
        }
    }
}