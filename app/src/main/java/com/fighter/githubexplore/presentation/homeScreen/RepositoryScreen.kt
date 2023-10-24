package com.fighter.githubexplore.presentation.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fighter.githubexplore.presentation.homeScreen.composables.RepositoryItem
import com.fighter.githubexplore.presentation.ui.theme.Theme

@JvmOverloads
@Composable
fun RepositoryScreen(viewModel: RepositoryViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    Repository(state)
}

@Composable
fun Repository(state: RepositoryUiState) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().background(Theme.colors.background),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(state.repositories) { repository ->
            RepositoryItem(repoState = repository)
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
fun PreviewRepositoryScreen() {
    RepositoryScreen()
}