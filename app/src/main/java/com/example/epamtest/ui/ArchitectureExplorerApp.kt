package com.example.epamtest.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.epamtest.ui.topics.TopicsScreen
import com.example.epamtest.ui.topics.TopicsViewModel

@Composable
fun ArchitectureExplorerApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        val viewModel: TopicsViewModel = viewModel()
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        TopicsScreen(
            uiState = uiState,
            modifier = Modifier.padding(innerPadding)
        )

    }
}