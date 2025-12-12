package com.shiv.taskapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shiv.taskapp.presentation.TaskViewModel
import com.shiv.taskapp.ui.addtask.AddTaskScreen
import com.shiv.taskapp.ui.home.TaskHomeScreen

@Composable
fun TaskNavGraph(
    navController: NavHostController
) {
    /**Shared ViewModel instance scoped to the Activity lifecycle.

    Reason ::->>>>>>>
     * Memory Efficiency: Using hiltViewModel() inside each composable creates separate
     * ViewModel instances per NavBackStackEntry, which is wasteful for screens sharing same data.
     **/

    val sharedViewModel: TaskViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = Routes.Home.route
    ) {
        composable(Routes.Home.route) {
            TaskHomeScreen(
                viewModel = sharedViewModel,
                onAddTaskClick = {
                    navController.navigate(Routes.AddTask.route)
                }
            )
        }
        composable(Routes.AddTask.route) {
            AddTaskScreen(
                viewModel = sharedViewModel,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}

