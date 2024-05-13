package com.ntp.todofactory.ui.screens.list

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text
import com.ntp.todofactory.data.models.Priority
import com.ntp.todofactory.data.models.ToDoTask
import com.ntp.todofactory.utils.RequestState
import com.ntp.todofactory.utils.SearchAppBarState

@Composable
fun ListContent(
    padding: PaddingValues ,
    allTasks: RequestState<List<ToDoTask>> ,
    searchedTasks: RequestState<List<ToDoTask>> ,
    searchAppBarState: SearchAppBarState ,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    if (searchAppBarState == SearchAppBarState.TRIGGERED) {
        if (searchedTasks is RequestState.Success) {
            HandleListContent(
                padding = padding,
                tasks = searchedTasks.data,
                navigateToTaskScreen = navigateToTaskScreen
            )
        }
    } else {
        if (allTasks is RequestState.Success) {
            HandleListContent(
                padding = padding ,
                tasks = allTasks.data,
                navigateToTaskScreen = navigateToTaskScreen
            )
        }
    }
}

@Composable
fun HandleListContent(
    padding: PaddingValues,
    tasks: List<ToDoTask>,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    if (tasks.isEmpty()) {
        EmptyContent()
    } else {
        DisplayTasks(
            padding = padding,
            tasks = tasks,
            navigateToTaskScreen = navigateToTaskScreen
        )
    }
}


@Composable
fun DisplayTasks(
    padding: PaddingValues,
    tasks: List<ToDoTask>,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier.padding(padding)
    ) {
        items(
            items = tasks,
            key = {task ->
                task.id
            }
        ) {task->
            TaskItem(
                toDoTask = task,
                navigateToTaskScreen = navigateToTaskScreen
            )
        }
    }
}

@Composable
fun TaskItem(
    toDoTask: ToDoTask,
    navigateToTaskScreen: (taskId: Int) -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 3.dp),
        color = MaterialTheme.colorScheme.inversePrimary,
        shape = RectangleShape,
        tonalElevation = 2.dp,
        onClick = {
            navigateToTaskScreen(toDoTask.id)
        }
    ) {
        Column(
            modifier = Modifier
                .padding(all = 12.dp)
                .fillMaxWidth()
        ) {
            Row {
                Text(
                    text = toDoTask.title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    modifier = Modifier.weight(8f)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Canvas(
                        modifier = Modifier
                            .size(20.dp)
                    ) {
                        drawCircle(
                            color = toDoTask.priority.color
                        )
                    }
                }
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = toDoTask.description,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
private fun TaskItemPreview() {
    TaskItem(
        toDoTask = ToDoTask(
            id = 0,
            title = "My Title",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            priority = Priority.HIGH
        ),
        navigateToTaskScreen = {}
    )
}