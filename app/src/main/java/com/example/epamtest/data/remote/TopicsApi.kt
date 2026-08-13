package com.example.epamtest.data.remote

import retrofit2.http.GET

interface TopicsApi {

    @GET("posts")
    suspend fun getTopics(): List<TopicDto>
}