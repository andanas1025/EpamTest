package com.example.epamtest.ui.topics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.epamtest.data.repository.TopicsRepository

class TopicsViewModelFactory(
    private val repository: TopicsRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {
        if (modelClass.isAssignableFrom(TopicsViewModel::class.java)) {
            return TopicsViewModel(repository) as T
        }

        throw IllegalArgumentException(
            "Unknown ViewModel class: ${modelClass.name}"
        )
    }
}