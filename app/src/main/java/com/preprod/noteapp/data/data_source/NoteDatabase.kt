package com.preprod.noteapp.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.preprod.noteapp.domain.model.Note
import com.preprod.noteapp.util.DateConverter
import com.preprod.noteapp.util.UUIDConverter

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDatabase : RoomDatabase() {
    abstract val noteDatabaseDao: NoteDatabaseDao

    companion object {
        const val DATABASE_NAME = "notes_db"
    }
}