package com.example.epamtest.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.epamtest.ui.topics.TopicsScreen

@Composable
fun ArchitectureExplorerApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        TopicsScreen(
            modifier = Modifier.padding(innerPadding)
        )

    }
}