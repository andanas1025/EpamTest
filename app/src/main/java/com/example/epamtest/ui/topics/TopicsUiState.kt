package com.example.epamtest.ui.topics

import com.example.epamtest.ui.topics.model.Topic

data class TopicsUiState(
    val topics: List<Topic> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

