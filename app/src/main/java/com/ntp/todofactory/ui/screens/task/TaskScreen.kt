package com.ntp.todofactory.ui.screens.task

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.ntp.todofactory.data.models.Priority
import com.ntp.todofactory.data.models.ToDoTask
import com.ntp.todofactory.ui.viewmodels.SharedViewModel
import com.ntp.todofactory.utils.Action

@Composable
fun TaskScreen(
    navigateToListScreen: (Action) -> Unit,
    sharedViewModel: SharedViewModel,
    selectedTask: ToDoTask?,
) {
    val title: String by sharedViewModel.title
    val description: String by sharedViewModel.description
    val priority: Priority by sharedViewModel.priority

    Scaffold(
        topBar = {
            TaskAppBar(
                navigateToListScreen = navigateToListScreen,
                selectedTask = selectedTask
            )
        },
        content = {innerPadding ->
            TaskContent(
                title = title,
                onTitleChange = {
                    sharedViewModel.updateTitle(it)
                } ,
                description = description ,
                onDescriptionChange = {
                    sharedViewModel.description.value = it
                } ,
                priority = priority,
                onPrioritySelected =  {
                    sharedViewModel.priority.value = it
                },
                padding = innerPadding
            )
        }
    )
}