package com.shiv.taskapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.shiv.taskapp.presentation.TaskViewModel

@Composable
fun TaskHomeScreen() {
    val viewModel = hiltViewModel<TaskViewModel>()
    val dataState = viewModel.myTaskState.collectAsState()

    Column {
        dataState.value.forEach {
            TaskItemComponent(data = it)
        }
        Text(
            "Add task",
            modifier = Modifier.clickable {
                viewModel.addNewTask()
            })

    }

}