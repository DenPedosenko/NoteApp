package com.preprod.noteapp.data.data_source

import androidx.room.*
import com.preprod.noteapp.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {

    @Query(value = "SELECT * from notes_tbl")
    fun getNotes(): Flow<List<Note>>

    @Query(value = "SELECT * from notes_tbl WHERE id = :id")
    suspend fun getNoteById(id: Int): Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}
