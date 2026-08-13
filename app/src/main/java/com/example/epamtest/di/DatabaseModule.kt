package com.example.epamtest.di

import android.content.Context
import androidx.room.Room
import com.example.epamtest.data.local.ArchitectureDatabase
import com.example.epamtest.data.local.TopicsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): ArchitectureDatabase {
        return Room.databaseBuilder(
            context,
            ArchitectureDatabase::class.java,
            "architecture_explorer.db"
        ).build()
    }

    @Provides
    fun provideTopicsDao(
        database: ArchitectureDatabase
    ): TopicsDao {
        return database.topicsDao()
    }
}