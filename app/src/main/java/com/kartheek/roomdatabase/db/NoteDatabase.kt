package com.kartheek.roomdatabase.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kartheek.roomdatabase.dao.NoteDao
import com.kartheek.roomdatabase.data.model.Note


@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = false
)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun appDao(): NoteDao
}