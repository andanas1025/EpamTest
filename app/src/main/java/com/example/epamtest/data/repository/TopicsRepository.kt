package com.example.epamtest.data.repository

import com.example.epamtest.data.di.qualifier.IoDispatcher
import com.example.epamtest.data.local.TopicEntity
import com.example.epamtest.data.local.TopicsLocalDataSource
import com.example.epamtest.data.remote.TopicsRemoteDataSource
import com.example.epamtest.model.Topic
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TopicsRepository @Inject constructor(
    private val localDataSource: TopicsLocalDataSource,
    private val remoteDataSource: TopicsRemoteDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {

    fun observeTopics(): Flow<List<Topic>> =
        localDataSource
            .observeTopics()
            .map { entities ->
                entities.map { it.toDomain() }
            }

    suspend fun refreshTopics(): RefreshResult = withContext(ioDispatcher) {
        try {
            val remoteTopics = remoteDataSource.getTopics()

            val entities = remoteTopics.map { dto ->
                TopicEntity(
                    id = dto.id.toString(),
                    title = dto.title,
                    description = dto.body
                )
            }

            localDataSource.insertTopics(entities)

            RefreshResult.Success

        } catch (exception: Exception) {
            RefreshResult.Error(exception)
        }
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