package com.kartheek.roomdatabase.dao

import androidx.room.*
import com.kartheek.roomdatabase.data.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

   //To get all registered users
    @Query("SELECT * FROM Note")
     fun getAllNotes(): Flow<List<Note>>


}