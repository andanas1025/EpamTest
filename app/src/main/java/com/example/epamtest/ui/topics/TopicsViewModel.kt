package com.example.epamtest.ui.topics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.epamtest.data.repository.TopicsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TopicsViewModel : ViewModel() {

    private val repository = TopicsRepository()
    private val _uiState = MutableStateFlow(
        TopicsUiState()
    )
    val uiState: StateFlow<TopicsUiState> = _uiState

    init {
        loadTopics()
    }

    private fun loadTopics() {
        viewModelScope.launch {
            repository
                .getTopics()
                .collect { topics ->
                    _uiState.value = TopicsUiState(
                        topics = topics
                    )
                }
        }
    }
}