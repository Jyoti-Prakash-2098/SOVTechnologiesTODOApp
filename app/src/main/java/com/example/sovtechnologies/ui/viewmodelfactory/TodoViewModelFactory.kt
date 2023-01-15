package com.example.sovtechnologies.ui.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sovtechnologies.ui.db.TasksDatabase
import com.example.sovtechnologies.ui.viewmodel.TodoViewModel

@Suppress("UNCHECKED_CAST")
class TodoViewModelFactory(private val db:TasksDatabase):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TodoViewModel(db) as T
    }
}