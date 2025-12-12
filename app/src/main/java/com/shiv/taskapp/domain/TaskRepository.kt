package com.shiv.taskapp.domain

import com.shiv.taskapp.data.TaskData
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getAllTasks(): Flow<List<TaskData>>
    suspend fun insertTask(task: TaskData)
    suspend fun deleteTaskById(id: Int)
}