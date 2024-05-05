package com.ntp.todofactory.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ntp.todofactory.utils.Constants.DATABASE_TABLE

@Entity(tableName = DATABASE_TABLE)
data class ToDoTask(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val description: String,
    val priority: Priority
)
