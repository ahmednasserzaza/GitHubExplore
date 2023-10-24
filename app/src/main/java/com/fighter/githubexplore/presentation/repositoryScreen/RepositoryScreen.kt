package com.fighter.githubexplore.presentation.repositoryScreen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.fighter.githubexplore.R
import com.fighter.githubexplore.presentation.repositoryScreen.composables.RepositoryDetailsItem
import com.fighter.githubexplore.presentation.repositoryScreen.composables.RepositoryItem
import com.fighter.githubexplore.presentation.repositoryScreen.composables.shimmerEffect
import com.fighter.githubexplore.presentation.ui.theme.Theme

@OptIn(ExperimentalAnimationApi::class)
@JvmOverloads
@Composable
fun RepositoryScreen(viewModel: RepositoryViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    RepositoryScreenContent(state = state, listener = viewModel)

    AnimatedContent(state.isLoading, label = "") {
        if (state.isLoading) {
            LoadingEffect()
        } else if (state.error.isNotEmpty()) {
            ErrorView()
        } else {
            RepositoryScreenContent(state = state, listener = viewModel)
        }
    }
}

@Composable
fun RepositoryScreenContent(
    state: RepositoryScreenUiState,
    listener: RepositoryScreenInteractionListener,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Theme.colors.background),
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

@Composable
private fun ErrorView() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.error))
    val progress by animateLottieCompositionAsState(composition)
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        LottieAnimation(
            modifier = Modifier.size(200.dp),
            composition = composition,
            progress = { progress },
        )
    }

}

@Composable
private fun LoadingEffect() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Theme.colors.background),
        contentAlignment = Alignment.BottomCenter
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(10) {
                RepositoryLoadingEffect()
            }
        }
    }
}

@Composable
private fun RepositoryLoadingEffect() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .shimmerEffect()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(48.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(shape = CircleShape)
                    .shimmerEffect()
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .shimmerEffect()
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .shimmerEffect()
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .shimmerEffect()
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun ShimmerEffect() {
    RepositoryLoadingEffect()
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
fun PreviewRepositoryScreen() {
    RepositoryScreen()
}