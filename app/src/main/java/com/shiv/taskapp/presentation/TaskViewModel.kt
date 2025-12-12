package com.shiv.taskapp.presentation

import androidx.lifecycle.ViewModel
import com.shiv.taskapp.data.TaskData
import com.shiv.taskapp.domain.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    val repository: TaskRepository
) : ViewModel() {

    private val _myTaskState: MutableStateFlow<List<TaskData>> = MutableStateFlow(emptyList())
    val myTaskState = _myTaskState.asStateFlow()


    fun addNewTask(task: TaskData) {
        _myTaskState.value += task

      //  repository.addNewTask(task)
    }

    fun deleteTask(id: Int) {
        _myTaskState.value = _myTaskState.value.filter { it.id != id }
    }

}