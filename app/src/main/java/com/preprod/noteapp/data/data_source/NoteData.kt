package com.preprod.noteapp.data.data_source

import com.preprod.noteapp.domain.model.Note

object NotesDataSource {
    fun loadNotes(): List<Note> {
        return listOf(
            Note(title = "Title", description = "Description"),
            Note(title = "Title", description = "Description"),
            Note(title = "Title", description = "Description")
        )
    }
}