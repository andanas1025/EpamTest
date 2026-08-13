package com.example.epamtest.data.repository

import com.example.epamtest.data.local.TopicEntity
import com.example.epamtest.data.local.TopicsLocalDataSource
import com.example.epamtest.data.local.initialTopics
import com.example.epamtest.model.Topic
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TopicsRepository @Inject constructor(
    private val localDataSource: TopicsLocalDataSource
) {

    fun observeTopics(): Flow<List<Topic>> =
        localDataSource
            .observeTopics()
            .map { entities ->
                entities.map { it.toDomain() }
            }

    suspend fun refreshTopics() {
        localDataSource.insertTopics(
            initialTopics.map { it.toEntity() }
        )
    }
}

fun Topic.toEntity(): TopicEntity =
    TopicEntity(
        id = id,
        title = title,
        description = description
    )

fun TopicEntity.toDomain(): Topic =
    Topic(
        id = id,
        title = title,
        description = description
    )