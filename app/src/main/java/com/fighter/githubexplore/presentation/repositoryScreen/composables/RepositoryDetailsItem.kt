package com.fighter.githubexplore.presentation.repositoryScreen.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.fighter.githubexplore.R
import com.fighter.githubexplore.presentation.repositoryScreen.RepositoryDetailsUiState
import com.fighter.githubexplore.presentation.ui.theme.Theme

@Composable
fun RepositoryDetailsItem(
    repoDetailsState: RepositoryDetailsUiState,
    onClickExit: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(topEnd = 24.dp, topStart = 24.dp))
            .background(Theme.colors.secondary)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        RepositoryHeaderRow(repoDetailsState = repoDetailsState, onClickExit = onClickExit)
        RepositoryRowItem(
            textContent = repoDetailsState.repoName,
            hint = stringResource(R.string.repository_name)
        )
        RepositoryRowItem(
            textContent = repoDetailsState.description,
            hint = stringResource(R.string.description)
        )
        RepositoryRowItem(
            textContent = repoDetailsState.createdAt,
            hint = stringResource(R.string.created_at)
        )
        OwnerContentRow(repoDetailsState = repoDetailsState)
    }
}

@Composable
private fun OwnerContentRow(
    repoDetailsState: RepositoryDetailsUiState,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(48.dp, Alignment.Start),
    ) {
        Text(
            text = stringResource(R.string.owner),
            style = Theme.typography.body,
            color = Theme.colors.hint,
        )
        OwnerContent(owner = repoDetailsState.owner)
    }
}

@Composable
private fun RepositoryHeaderRow(
    repoDetailsState: RepositoryDetailsUiState,
    modifier: Modifier = Modifier,
    onClickExit: () -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = stringResource(R.string.stars),
                tint = Theme.colors.primary
            )
            Text(
                text = repoDetailsState.starsCount.toString(),
                style = Theme.typography.titleMedium,
                color = Theme.colors.onSurface,
            )
        }
        Icon(
            modifier = Modifier.noRippleEffect { onClickExit() },
            imageVector = Icons.Filled.Close,
            contentDescription = stringResource(R.string.icon_close),
            tint = Theme.colors.onSurface
        )
    }
}

@Composable
private fun RepositoryRowItem(
    textContent: String,
    hint: String,
    modifier: Modifier = Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.spacedBy(16.dp, Alignment.Start),
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = horizontalArrangement
    ) {
        Text(
            text = hint,
            style = Theme.typography.body,
            color = Theme.colors.hint,
        )
        Text(
            text = textContent,
            style = Theme.typography.body,
            color = Theme.colors.onSurface,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}