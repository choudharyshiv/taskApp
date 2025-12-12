package com.shiv.taskapp.ui.addtask

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shiv.taskapp.data.TaskData
import com.shiv.taskapp.presentation.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskScreen(
    viewModel: TaskViewModel,
    onNavigateBack: () -> Unit,
) {
    // using rememberSaveable to survives configuration changes
    var title by rememberSaveable { mutableStateOf("") }
    var description by rememberSaveable { mutableStateOf("") }
    var titleError by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add Task") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            item {
                OutlinedTextField(
                    value = title,
                    onValueChange = {
                        title = it
                        titleError = false
                    },
                    label = { Text("Title") },
                    placeholder = { Text("Enter task title") },
                    isError = titleError,
                    supportingText = if (titleError) {
                        { Text("Title is required") }
                    } else null,
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Description") },
                    placeholder = { Text("Enter task description") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    maxLines = 5
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        if (title.isBlank()) {
                            titleError = true
                        } else {
                            viewModel.addNewTask(
                                TaskData(
                                    title = title.trim(),
                                    description = description.trim()
                                )
                            )
                            onNavigateBack()
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Add Task")
                }
            }
        }
    }
}

