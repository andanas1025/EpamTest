package com.example.epamtest.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.epamtest.ui.topics.TopicsScreen
import com.example.epamtest.ui.topics.TopicsUiState
import com.example.epamtest.ui.topics.sampleTopics

@Composable
fun ArchitectureExplorerApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        TopicsScreen(
            uiState = TopicsUiState(
                topics = sampleTopics
            ),
            modifier = Modifier.padding(innerPadding)
        )

    }
}