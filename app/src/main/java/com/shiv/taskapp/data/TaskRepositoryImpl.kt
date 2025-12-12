package com.shiv.taskapp.data

import com.shiv.taskapp.data.local.TaskDao
import com.shiv.taskapp.domain.TaskRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    private val taskDao: TaskDao
) : TaskRepository {

    override fun getAllTasks(): Flow<List<TaskData>> {
        return taskDao.getAllTasks() //as discussed added flow to update ui directly from room
    }

    override suspend fun insertTask(task: TaskData) {
        taskDao.insertTask(task)
    }

    override suspend fun deleteTaskById(id: Int) {
        taskDao.deleteTaskById(id)
    }
}