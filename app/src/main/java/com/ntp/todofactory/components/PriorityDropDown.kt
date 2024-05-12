package com.ntp.todofactory.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.ContentAlpha
import com.ntp.todofactory.R
import com.ntp.todofactory.data.models.Priority

@Composable
fun PriorityDropDown(
    priority: Priority,
    onPrioritySelected: (Priority) -> Unit
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    val angle: Float by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f , label = ""
    )
    var borderColor = if(expanded) {
        MaterialTheme.colorScheme.primary
    } else MaterialTheme.colorScheme.onSurface.copy(alpha = ContentAlpha.medium)
    var borderWidth = if(expanded) 2.dp else 1.dp
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clickable { expanded = true }
            .border(
                width = borderWidth,
                color = borderColor ,
                shape = MaterialTheme.shapes.extraSmall
            )
            .onFocusChanged { },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Canvas(
            modifier = Modifier
                .size(16.dp)
                .weight(1f)
        ) {
            drawCircle(color = priority.color)
        }
        Text(
            modifier = Modifier
                .weight(8f),
            text = priority.name,
            style = MaterialTheme.typography.labelSmall
        )
        IconButton(
            onClick = { expanded = true },
            modifier = Modifier
                .alpha(ContentAlpha.medium)
                .rotate(angle)
                .weight(1f),
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = stringResource(R.string.drop_down_arrow_button_description)
            )
        }
        DropdownMenu(
            modifier = Modifier
                .fillMaxWidth(fraction = 0.943f),
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            Priority.entries.toTypedArray().slice(0..2).forEach { priority ->
                DropdownMenuItem(
                    text = { PriorityItem(priority = priority) },
                    onClick = {
                        expanded = false
                        onPrioritySelected(priority)
                    },
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PriorityDropDownPreview() {
    PriorityDropDown(
        priority = Priority.LOW,
        onPrioritySelected = {}
    )
}