package com.preprod.noteapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant


import java.util.*

@Entity(tableName = Note.TABLE_NAME)
data class Note(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    val entryDate: Date = Date.from(Instant.now())
) {
    companion object{
      const val  TABLE_NAME = "Notes_tbl"
    }
}
