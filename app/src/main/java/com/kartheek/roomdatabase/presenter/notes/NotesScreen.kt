package com.kartheek.roomdatabase.presenter.notes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.kartheek.roomdatabase.core.NetworkResult
import com.kartheek.roomdatabase.core.showToast
import com.kartheek.roomdatabase.data.model.Note
import com.kartheek.roomdatabase.presenter.components.*


@Composable
@ExperimentalMaterialApi
fun NoteScreen(
    viewModel: NoteViewModel
){
    val noteState by viewModel.uiState.collectAsState()
    //using material not material3
    Scaffold(
        topBar = {
            NotesTopBar()
        },
        content = { padding ->
            NoteScreenContent(
                padding = padding,
                noteUiState = noteState
            )
            AddNoteAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = {
                    viewModel.closeDialog()
                },
                addNote = { note ->
                    viewModel.addNote(note)
                }
            )
        },
        floatingActionButton = {
            AddBookFloatingActionButton(
                openDialog = {
                    viewModel.openDialog()
                }
            )
        }
    )
}

@ExperimentalMaterialApi
@Composable
private fun NoteScreenContent(
    padding: PaddingValues,
    noteUiState: NetworkResult<List<Note>>
) {
        when (noteUiState) {
            is NetworkResult.Loading -> {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    CircularProgressBar(
                        modifier = Modifier
                            .padding(top = 16.dp)
                    )
                }
            }
            is NetworkResult.Success -> {
                if (noteUiState.data != null) {
                    NotesContentUI(
                        padding = padding,
                        notes = noteUiState.data
                    )
                }
            }
            is NetworkResult.Error -> {
                val context = LocalContext.current
                context.showToast("Something went wrong, please try again.")
            }
        }
}