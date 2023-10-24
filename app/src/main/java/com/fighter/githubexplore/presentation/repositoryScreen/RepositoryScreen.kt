package com.fighter.githubexplore.presentation.repositoryScreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fighter.githubexplore.presentation.repositoryScreen.composables.RepositoryDetailsItem
import com.fighter.githubexplore.presentation.repositoryScreen.composables.RepositoryItem
import com.fighter.githubexplore.presentation.ui.theme.Theme

@JvmOverloads
@Composable
fun RepositoryScreen(viewModel: RepositoryViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    Repository(state = state, listener = viewModel)
}

@Composable
fun Repository(
    state: RepositoryScreenUiState,
    listener: RepositoryScreenInteractionListener,
) {
    Box(
        modifier = Modifier.fillMaxSize().background(Theme.colors.background),
        contentAlignment = Alignment.BottomCenter
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(state.repositories) { repository ->
                RepositoryItem(repoState = repository, onClick = listener::onRepositoryClicked)
            }
        }

        AnimatedVisibility(visible = state.showRepositoryDetails) {
            RepositoryDetailsItem(
                modifier = Modifier.align(Alignment.BottomCenter),
                repoDetailsState = state.repositoryDetails,
                onClickExit = listener::onExitClicked
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
fun PreviewRepositoryScreen() {
    RepositoryScreen()
}