package com.fighter.githubexplore.presentation.repositoryScreen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.fighter.githubexplore.presentation.repositoryScreen.RepositoryUiState
import com.fighter.githubexplore.presentation.ui.theme.Theme

@Composable
fun RepositoryItem(
    repoState: RepositoryUiState,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(160.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(Theme.colors.secondary)
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OwnerContent(repoState)
        Column(
            modifier = Modifier.fillMaxSize(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.End),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "",
                        tint = Theme.colors.primary
                    )
                    Text(
                        text = repoState.starsCount.toString(),
                        style = Theme.typography.titleMedium,
                        color = Theme.colors.onSurface,
                    )
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "repository: ",
                        style = Theme.typography.body,
                        color = Theme.colors.hint
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth().padding(end = 8.dp),
                        text = repoState.repositoryName,
                        style = Theme.typography.titleMedium,
                        color = Theme.colors.onSurface,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Text(
                    modifier = Modifier.fillMaxWidth().padding(end = 8.dp),
                    text = repoState.description,
                    style = Theme.typography.body,
                    color = Theme.colors.hint,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Text(
                modifier = Modifier.fillMaxWidth().padding(end = 8.dp),
                text = repoState.createdAt,
                style = Theme.typography.body,
                color = Theme.colors.hint,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Start
            )
        }
    }
}

@Composable
private fun OwnerContent(repoState: RepositoryUiState) {
    Column(
        modifier = Modifier.fillMaxWidth(0.3f).fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
    ) {
        Image(
            modifier = Modifier.size(60.dp).clip(shape = CircleShape),
            painter = rememberAsyncImagePainter(model = repoState.imageUrl),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
        Text(
            text = repoState.ownerName,
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
    RepositoryItem(RepositoryUiState())
}