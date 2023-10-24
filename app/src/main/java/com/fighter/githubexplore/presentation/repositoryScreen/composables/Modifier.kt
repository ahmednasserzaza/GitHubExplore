package com.fighter.githubexplore.presentation.repositoryScreen.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

fun Modifier.noRippleEffect(onClick: () -> Unit) = composed { clickable(
    interactionSource = remember { MutableInteractionSource() },
    indication = null,
    onClick = onClick
) }