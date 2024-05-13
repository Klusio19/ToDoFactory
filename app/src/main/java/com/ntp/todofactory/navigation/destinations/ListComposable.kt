package com.ntp.todofactory.navigation.destinations

import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ntp.todofactory.ui.screens.list.ListScreen
import com.ntp.todofactory.ui.viewmodels.SharedViewModel
import com.ntp.todofactory.utils.Constants.LIST_ARGUMENT_KEY
import com.ntp.todofactory.utils.Constants.LIST_SCREEN
import com.ntp.todofactory.utils.toAction

fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY){
            type = NavType.StringType
        })
    ) {navBackStackEntry ->
        val action = navBackStackEntry.arguments?.getString(LIST_ARGUMENT_KEY).toAction()
        
        LaunchedEffect(key1 = action) {
            sharedViewModel.action.value = action
        }

        ListScreen(
            navigateToTaskScreen = navigateToTaskScreen,
            sharedViewModel = sharedViewModel
        )
    }
}