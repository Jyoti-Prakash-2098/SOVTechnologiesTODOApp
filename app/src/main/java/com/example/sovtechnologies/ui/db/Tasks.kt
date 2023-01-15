package com.example.sovtechnologies.ui.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Tasks(
    val title: String,
    val description: String,
    val status: String,
    val priorityColor: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
