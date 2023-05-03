package com.kartheek.roomdatabase.presenter.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kartheek.roomdatabase.data.model.Note

@Composable
@ExperimentalMaterialApi
fun NotesContentUI(
    padding: PaddingValues,
    notes: List<Note>
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(padding)
    ) {
        items(
            items = notes
        ){
            NoteCard(
                note = it,
            )
        }
    }
}