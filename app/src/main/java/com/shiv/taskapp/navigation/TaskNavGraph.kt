package com.shiv.taskapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shiv.taskapp.ui.addtask.AddTaskScreen
import com.shiv.taskapp.ui.home.TaskHomeScreen

@Composable
fun TaskNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Home.route
    ) {
        composable(Routes.Home.route) {
            TaskHomeScreen(
                onAddTaskClick = {
                    navController.navigate(Routes.AddTask.route)
                }
            )
        }
        composable(Routes.AddTask.route) {
            AddTaskScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}

