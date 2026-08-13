package com.example.epamtest.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "topics"
)
data class TopicEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val description: String
)