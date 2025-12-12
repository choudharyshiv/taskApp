package com.shiv.taskapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.shiv.taskapp.data.TaskData

@Database(
    entities = [TaskData::class],
    version = 1,
    exportSchema = false
)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}

