package com.example.epamtest.data.repository

import com.example.epamtest.data.local.FakeTopicsDataSource
import com.example.epamtest.model.Topic
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TopicsRepository {

    fun getTopics(): Flow<List<Topic>> {
        return flow {
            emit(FakeTopicsDataSource.topics)
        }
    }
}