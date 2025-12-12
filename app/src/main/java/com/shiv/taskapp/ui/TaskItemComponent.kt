package com.shiv.taskapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shiv.taskapp.data.TaskData

@Composable
fun TaskItemComponent(data: TaskData) {

    Box(modifier = Modifier.padding(16.dp)) {

        Row {
            Text(
                text = "Delete",
                style = MaterialTheme.typography.bodySmall
            )

            Column {
                Text(
                    text = data.title,
                    style = MaterialTheme.typography.bodyMedium

                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = data.description,
                    style = MaterialTheme.typography.bodySmall
                )
            }

        }
    }

}