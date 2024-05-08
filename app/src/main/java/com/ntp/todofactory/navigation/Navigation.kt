package com.ntp.todofactory.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.ntp.todofactory.navigation.destinations.listComposable
import com.ntp.todofactory.navigation.destinations.taskComposable
import com.ntp.todofactory.utils.Constants.LIST_SCREEN

@Composable
fun SetupNavigation(
    navController: NavHostController,
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    ) {
        listComposable(
            navigateToTaskScreen = screen.task
        )
        taskComposable(
            navigateToListScreen = screen.list
        )
    }
}