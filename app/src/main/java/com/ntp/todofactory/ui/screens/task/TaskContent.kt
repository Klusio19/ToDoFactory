package com.ntp.todofactory.ui.screens.task

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.ntp.todofactory.R
import com.ntp.todofactory.components.PriorityDropDown
import com.ntp.todofactory.data.models.Priority

@Composable
fun TaskContent(
    title: String ,
    onTitleChange: (String) -> Unit ,
    description: String ,
    onDescriptionChange: (String) -> Unit ,
    priority: Priority,
    onPrioritySelected: (Priority) -> Unit,
    padding: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(all = 12.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            value = title ,
            onValueChange = { onTitleChange(it) },
            label = { Text(text = stringResource(R.string.title)) },
            textStyle = MaterialTheme.typography.bodyMedium,
            singleLine = true
        )
        PriorityDropDown(
            priority = priority ,
            onPrioritySelected = onPrioritySelected
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxSize(),
            value = description ,
            onValueChange = { onDescriptionChange(it) },
            label = { Text(text = stringResource(R.string.description_label)) },
            textStyle = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun TaskContentPreview() {
    TaskContent(
        title = "My title" ,
        onTitleChange = {} ,
        description = LoremIpsum(50).values.first() ,
        onDescriptionChange = {} ,
        priority = Priority.MEDIUM ,
        onPrioritySelected = {},
        padding = PaddingValues()
    )
}