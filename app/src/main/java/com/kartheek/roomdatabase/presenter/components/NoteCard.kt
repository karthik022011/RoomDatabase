package com.kartheek.roomdatabase.presenter.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kartheek.roomdatabase.data.model.Note

@Composable
@ExperimentalMaterialApi
fun NoteCard(
    note: Note
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
                bottom = 4.dp
            )
            .fillMaxWidth(),
        elevation = 3.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                TextTitle(
                    noteTitle = note.title
                )
                TextDescription(
                    bookAuthor = note.description
                )
            }
            Spacer(
                modifier = Modifier.weight(1f)
            )
        }
    }
}