package com.ntp.todofactory.navigation.destinations

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ntp.todofactory.ui.screens.task.TaskScreen
import com.ntp.todofactory.ui.viewmodels.SharedViewModel
import com.ntp.todofactory.utils.Action
import com.ntp.todofactory.utils.Constants.TASK_ARGUMENT_KEY
import com.ntp.todofactory.utils.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (Action) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY){
            type = NavType.IntType
        })
    ) {navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        sharedViewModel.getSelectedTask(taskId)
        val selectedTask by sharedViewModel.selectedTask.collectAsState()

        TaskScreen(
            navigateToListScreen = navigateToListScreen,
            selectedTask = selectedTask
        )
    }
}