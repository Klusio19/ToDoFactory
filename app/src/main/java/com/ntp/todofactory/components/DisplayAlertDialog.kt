package com.ntp.todofactory.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.OutlinedButton
import com.ntp.todofactory.R

@Composable
fun DisplayAlertDialog(
    title: String ,
    message: String ,
    openDialog: Boolean ,
    closeDialog: () -> Unit ,
    onYesClicked: () -> Unit ,
) {
    if (openDialog) {
        AlertDialog(
            title = {
                Text(
                    text = title,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Text(
                    text = message,
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    fontWeight = FontWeight.Bold
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        onYesClicked()
                        closeDialog()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(text = stringResource(R.string.yes), color = MaterialTheme.colorScheme.onPrimary)
                }
            },
            dismissButton = {
                OutlinedButton(
                    onClick = {
                        closeDialog()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(text = stringResource(R.string.no), color = MaterialTheme.colorScheme.primary)
                }
            },
            onDismissRequest = {
                closeDialog()
            }
        )
    }
}