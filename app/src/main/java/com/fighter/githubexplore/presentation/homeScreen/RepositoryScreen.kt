package com.fighter.githubexplore.presentation.homeScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun RepositoryScreen(viewModel: RepositoryViewModel) {
    val state by viewModel.state.collectAsState()
    Repository(state)
}

@Composable
fun Repository(state: RepositoryUiState) {

}