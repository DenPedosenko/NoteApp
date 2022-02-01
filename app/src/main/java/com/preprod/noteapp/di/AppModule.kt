package com.preprod.noteapp.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.preprod.noteapp.data.data_source.NoteDatabase
import com.preprod.noteapp.data.data_source.NoteDatabaseDao
import com.preprod.noteapp.data.repository.NoteRepositoryImpl
import com.preprod.noteapp.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNoteRepository(database: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(database.noteDatabaseDao)
    }

    @Singleton
    @Provides
    fun provideAppDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        )
            .build()
    }
}