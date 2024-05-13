package com.ntp.todofactory.ui.screens.task

import android.content.Context
import android.widget.Toast
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
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

    val context = LocalContext.current

    Scaffold(
        topBar = {
            TaskAppBar(
                navigateToListScreen = {action ->
                   if (action == Action.NO_ACTION) {
                       navigateToListScreen(action)
                   } else {
                       if (sharedViewModel.validateFields()) {
                           navigateToListScreen(action)
                       } else {
                            displayToast(context = context)
                       }
                   }
                },
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

fun displayToast(context: Context) {
    Toast.makeText(context, "Fields Empty!", Toast.LENGTH_SHORT).show()
}
