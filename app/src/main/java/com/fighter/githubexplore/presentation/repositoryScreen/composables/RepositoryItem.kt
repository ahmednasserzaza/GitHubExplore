package com.fighter.githubexplore.presentation.repositoryScreen.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fighter.githubexplore.R
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

@Preview(showBackground = true, widthDp = 360)
@Composable
fun Preview() {
    RepositoryItem(RepositoryUiState(), onClick = { _, _ -> })
}