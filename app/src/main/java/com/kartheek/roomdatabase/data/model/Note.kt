package com.kartheek.roomdatabase.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kartheek.roomdatabase.core.MyAppConstants.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val description: String
)