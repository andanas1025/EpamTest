package com.example.epamtest.ui.topics

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TopicsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        TopicsUiState(
            topics = sampleTopics
        )
    )

    val uiState: StateFlow<TopicsUiState> = _uiState
}