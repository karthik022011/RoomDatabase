package com.kartheek.roomdatabase.presenter.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kartheek.roomdatabase.core.MyAppConstants.Empty_VALUE
import kotlinx.coroutines.job
import com.kartheek.roomdatabase.R
import com.kartheek.roomdatabase.data.model.Note

@Composable
fun AddNoteAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addNote: (note: Note) -> Unit
) {
    if (openDialog) {
        var title by remember { mutableStateOf(Empty_VALUE) }
        var description by remember { mutableStateOf(Empty_VALUE) }
        val focusRequester = FocusRequester()

        AlertDialog(
            onDismissRequest = closeDialog,
            title = {
                Text(
                    text = stringResource(R.string.add_note)
                )
            },
            text = {
                Column {
                    TextField(
                        value = title,
                        onValueChange = { title = it },
                        placeholder = {
                            Text(
                                text = stringResource(R.string.add_note)
                            )
                        },
                        modifier = Modifier.focusRequester(focusRequester)
                    )
                    LaunchedEffect(Unit) {
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = description,
                        onValueChange = { description = it },
                        placeholder = {
                            Text(
                                text =  stringResource(R.string.description)
                            )
                        }
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        val note = Note(0, title, description)
                        addNote(note)
                    }
                ) {
                    Text(
                        text = stringResource(R.string.add)
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog
                ) {
                    Text(
                        text = stringResource(R.string.dismiss)
                    )
                }
            }
        )
    }
}