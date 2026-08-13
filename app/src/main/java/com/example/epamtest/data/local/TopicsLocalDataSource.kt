package com.example.epamtest.data.local

import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class TopicsLocalDataSource @Inject constructor(
    private val topicsDao: TopicsDao
) {

    fun observeTopics(): Flow<List<TopicEntity>> {
        return topicsDao.observeTopics()
    }

    suspend fun insertTopics(topics: List<TopicEntity>) {
        topicsDao.insertTopics(topics)
    }
}