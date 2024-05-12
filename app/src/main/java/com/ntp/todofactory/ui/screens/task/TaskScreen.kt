package com.ntp.todofactory.ui.screens.task

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ntp.todofactory.data.models.ToDoTask
import com.ntp.todofactory.utils.Action

@Composable
fun TaskScreen(
    navigateToListScreen: (Action) -> Unit,
    selectedTask: ToDoTask?
) {
    Scaffold(
        topBar = {
            TaskAppBar(
                navigateToListScreen = navigateToListScreen,
                selectedTask = selectedTask
            )
        },
        content = {innerPadding ->
            Surface(modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)) {

            }
        }
    )
}