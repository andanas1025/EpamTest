package com.example.epamtest.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.epamtest.ui.topics.TopicsScreen
import com.example.epamtest.ui.topics.TopicsViewModel

@Composable
fun ArchitectureExplorerApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        val viewModel: TopicsViewModel = hiltViewModel()
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        TopicsScreen(
            uiState = uiState,
            onRefresh = viewModel::refreshTopics,
            modifier = Modifier.padding(innerPadding)
        )

    }
}