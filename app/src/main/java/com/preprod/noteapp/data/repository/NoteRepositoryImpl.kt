package com.preprod.noteapp.data.repository

import com.preprod.noteapp.data.data_source.NoteDatabaseDao
import com.preprod.noteapp.domain.model.Note
import com.preprod.noteapp.domain.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn

class NoteRepositoryImpl(private val dao: NoteDatabaseDao) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes().flowOn(Dispatchers.IO).conflate()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id = id)
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note = note)
    }

    override suspend fun updateNote(note: Note) {
        dao.updateNote(note = note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note = note)
    }
}