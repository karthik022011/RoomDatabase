package com.kartheek.roomdatabase.presenter.editnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.kartheek.roomdatabase.presenter.notes.NoteScreen
import com.kartheek.roomdatabase.presenter.notes.NoteViewModel
import com.kartheek.weatherapp.theme.NoteAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteEditActivity : ComponentActivity()  {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {

                }
            }
        }
    }
}