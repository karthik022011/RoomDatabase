package com.kartheek.roomdatabase.presenter.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.kartheek.roomdatabase.R

@Composable
fun NotesTopBar() {
    TopAppBar (
        title = {
            Text(
                text = stringResource(R.string.notes)
            )
        }
    )
}