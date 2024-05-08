package com.ntp.todofactory.navigation

import androidx.navigation.NavHostController
import com.ntp.todofactory.utils.Action
import com.ntp.todofactory.utils.Constants.LIST_SCREEN

class Screens(navController: NavHostController) {
    val list: (Action) -> Unit = {action ->
        navController.navigate(route = "list/${action.name}") {
            popUpTo(route = LIST_SCREEN) { inclusive = true }
        }
    }

    val task: (Int) -> Unit = {taskId ->
        navController.navigate(route = "task/$taskId")
    }
}