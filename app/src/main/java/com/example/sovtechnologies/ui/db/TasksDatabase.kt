package com.example.sovtechnologies.ui.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Tasks::class],
    version = 1
)
abstract class TasksDatabase : RoomDatabase() {
    abstract fun getTasksDao(): TasksDao

    companion object {
        @Volatile
        private var instance: TasksDatabase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            TasksDatabase::class.java,
            "TasksDatabase"
        ).build()
    }
}