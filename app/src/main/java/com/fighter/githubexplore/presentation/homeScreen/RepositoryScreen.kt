package com.fighter.githubexplore.presentation.homeScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RepositoryScreen(viewModel: RepositoryViewModel) {
    val state by viewModel.state.collectAsState()
    Repository(state)
}

@Composable
fun Repository(state: RepositoryUiState) {

}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
fun PreviewRepositoryScreen() {
    Repository(RepositoryUiState())
}