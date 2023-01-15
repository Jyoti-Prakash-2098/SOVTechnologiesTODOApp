package com.example.sovtechnologies.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.sovtechnologies.R
import com.example.sovtechnologies.ui.db.Tasks
import com.example.sovtechnologies.ui.db.TasksDatabase
import com.example.sovtechnologies.ui.viewmodel.TodoViewModel
import com.example.sovtechnologies.ui.viewmodelfactory.TodoViewModelFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainNav) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this, navController)
        val viewModel = ViewModelProvider(
            this, TodoViewModelFactory(TasksDatabase(this))
        )[TodoViewModel::class.java]
        viewModel.checkData()
    }
}