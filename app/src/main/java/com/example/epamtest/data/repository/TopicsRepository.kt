package com.example.epamtest.data.repository

import com.example.epamtest.data.local.TopicEntity
import com.example.epamtest.data.local.TopicsDao
import com.example.epamtest.model.Topic
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TopicsRepository(
    private val topicsDao: TopicsDao
) {

    fun getTopics(): Flow<List<Topic>> {
        return topicsDao
            .observeTopics()
            .map { entities ->
                entities.map { entity ->
                    Topic(
                        id = entity.id,
                        title = entity.title,
                        description = entity.description
                    )
                }
            }
    }

    suspend fun initialize() {
        topicsDao.insertTopics(
            listOf(
                TopicEntity(
                    id = "mvvm",
                    title = "MVVM",
                    description = "Model-View-ViewModel"
                ),
                TopicEntity(
                    id = "mvi",
                    title = "MVI",
                    description = "Model-View-Intent"
                ),
                TopicEntity(
                    id = "clean",
                    title = "Clean Architecture",
                    description = "Separation of responsibilities"
                )
            )
        )
    }
}