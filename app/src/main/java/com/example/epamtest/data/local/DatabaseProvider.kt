package com.example.epamtest.data.local

import android.content.Context
import androidx.room.Room

@Deprecated("This class is not using by any class")
object DatabaseProvider {

    fun create(context: Context): ArchitectureDatabase {
        return Room.databaseBuilder(
            context,
            ArchitectureDatabase::class.java,
            "architecture_explorer.db"
        ).build()
    }
}