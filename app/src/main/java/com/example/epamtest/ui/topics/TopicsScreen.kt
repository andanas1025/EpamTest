package com.example.epamtest.ui.topics

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.epamtest.ui.topics.model.Topic

private val topics = listOf(
    Topic(
        id = "mvvm",
        title = "MVVM",
        description = "Model-View-ViewModel"
    ),
    Topic(
        id = "mvi",
        title = "MVI",
        description = "Model-View-Intent"
    ),
    Topic(
        id = "clean",
        title = "Clean Architecture",
        description = "Separation of Concerns"
    )
)

@Composable
fun TopicsScreen(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(topics) { topic ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = topic.title,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = topic.description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}