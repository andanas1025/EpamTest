package com.example.epamtest.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.epamtest.data.local.DatabaseProvider
import com.example.epamtest.data.repository.TopicsRepository
import com.example.epamtest.ui.topics.TopicsScreen
import com.example.epamtest.ui.topics.TopicsViewModel
import com.example.epamtest.ui.topics.TopicsViewModelFactory

@Composable
fun ArchitectureExplorerApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        val context = LocalContext.current

        val database = remember {
            DatabaseProvider.create(context)
        }

        val repository = remember {
            TopicsRepository(
                topicsDao = database.topicsDao()
            )
        }

        val factory = remember {
            TopicsViewModelFactory(repository)
        }

        val viewModel: TopicsViewModel = viewModel(
            factory = factory
        )

        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        TopicsScreen(
            uiState = uiState,
            modifier = Modifier.padding(innerPadding)
        )

    }
}