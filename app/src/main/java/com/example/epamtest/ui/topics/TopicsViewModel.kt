package com.example.epamtest.ui.topics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.epamtest.data.repository.TopicsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopicsViewModel @Inject constructor(
    private val repository: TopicsRepository
) : ViewModel() {

    val uiState: StateFlow<TopicsUiState> = repository
        .observeTopics()
        .map { topics ->
            TopicsUiState(
                topics = topics
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = TopicsUiState(
                isLoading = true
            )
        )

    init {
        viewModelScope.launch {
            repository.refreshTopics()
        }
    }
}