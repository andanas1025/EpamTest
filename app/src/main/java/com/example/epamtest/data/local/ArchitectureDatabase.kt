package com.example.epamtest.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [TopicEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ArchitectureDatabase : RoomDatabase() {

    abstract fun topicsDao(): TopicsDao
}