package com.example.epamtest.data.remote

import jakarta.inject.Inject

class TopicsRemoteDataSource @Inject constructor(
    private val api: TopicsApi
) {

    suspend fun getTopics(): List<TopicDto> {
        return api.getTopics()
    }
}