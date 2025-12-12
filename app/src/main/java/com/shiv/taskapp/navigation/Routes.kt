package com.shiv.taskapp.navigation

sealed class Routes(val route: String) {
    data object Home : Routes("home")
    data object AddTask : Routes("add_task")
}

