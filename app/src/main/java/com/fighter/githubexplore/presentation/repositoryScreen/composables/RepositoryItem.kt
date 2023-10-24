package com.fighter.githubexplore.presentation.repositoryScreen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.fighter.githubexplore.R
import com.fighter.githubexplore.presentation.repositoryScreen.RepositoryOwnerUiState
import com.fighter.githubexplore.presentation.repositoryScreen.RepositoryUiState
import com.fighter.githubexplore.presentation.ui.theme.Theme

@Composable
fun RepositoryItem(
    repoState: RepositoryUiState,
    onClick: (ownerName: String, repoName: String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .noRippleEffect { onClick(repoState.owner.ownerName, repoState.repoName) }
            .clip(shape = RoundedCornerShape(8.dp))
            .background(Theme.colors.secondary)
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OwnerContent(owner = repoState.owner, modifier = Modifier.fillMaxWidth(0.3f))
        RepositoryContent(repoState)
    }
}

@Composable
private fun RepositoryContent(repoState: RepositoryUiState, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(1f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
    ) {
        Text(
            text = stringResource(R.string.repository_name),
            style = Theme.typography.body,
            color = Theme.colors.hint
        )
        Text(
            text = repoState.repoName,
            style = Theme.typography.titleMedium,
            color = Theme.colors.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun OwnerContent(owner: RepositoryOwnerUiState, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
    ) {
        Image(
            modifier = Modifier
                .size(60.dp)
                .clip(shape = CircleShape)
                .border(width = 2.dp, color = Theme.colors.primary, shape = CircleShape),
            painter = rememberAsyncImagePainter(model = owner.avatarUrl),
            contentDescription = stringResource(R.string.owner_avatar),
            contentScale = ContentScale.Crop
        )
        Text(
            text = owner.ownerName,
            style = Theme.typography.body,
            color = Theme.colors.onSurface,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun Preview() {
    RepositoryItem(RepositoryUiState(), onClick = { _, _ -> })
}