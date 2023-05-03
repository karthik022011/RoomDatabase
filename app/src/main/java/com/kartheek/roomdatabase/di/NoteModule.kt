package com.kartheek.roomdatabase.di

import com.kartheek.roomdatabase.data.repository.NoteRepository
import com.kartheek.roomdatabase.data.repository.NoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class NoteModule {

    @Binds
    abstract fun bindNoteInterface(
        noteRepositoryImpl: NoteRepositoryImpl
    ): NoteRepository
}