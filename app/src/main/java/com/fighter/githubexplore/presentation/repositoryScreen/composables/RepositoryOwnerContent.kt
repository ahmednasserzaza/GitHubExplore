package com.fighter.githubexplore.presentation.repositoryScreen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.fighter.githubexplore.R
import com.fighter.githubexplore.presentation.repositoryScreen.RepositoryOwnerUiState
import com.fighter.githubexplore.presentation.ui.theme.Theme

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