package com.example.sovtechnologies.ui.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TasksDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTask (tasks: Tasks)

    @Query("Select * from tasks")
    fun getNotesLive() : LiveData<MutableList<Tasks>>

    @Query("Select * from tasks")
    fun getNotes() : MutableList<Tasks>
}