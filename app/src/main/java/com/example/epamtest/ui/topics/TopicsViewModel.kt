package com.example.epamtest.ui.topics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.epamtest.data.repository.RefreshResult
import com.example.epamtest.data.repository.TopicsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopicsViewModel @Inject constructor(
    private val repository: TopicsRepository
) : ViewModel() {

    private val _refreshState = MutableStateFlow<RefreshResult?>(null)
    val uiState: StateFlow<TopicsUiState> =
        combine(
            repository.observeTopics(),
            _refreshState
        ) { topics, refreshResult ->
            TopicsUiState(
                topics = topics,
                isLoading = refreshResult == null,
                error = when (refreshResult) {
                    is RefreshResult.Error -> refreshResult.exception.message
                    else -> null
                }
            )
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = TopicsUiState(
                isLoading = true
            )
        )

    init {
        refreshTopics()
    }

    internal fun refreshTopics() {
        viewModelScope.launch {
            _refreshState.value = null

            val result = repository.refreshTopics()

            _refreshState.value = result
        }
    }
}