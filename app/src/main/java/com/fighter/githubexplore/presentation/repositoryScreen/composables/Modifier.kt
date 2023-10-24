package com.fighter.githubexplore.presentation.repositoryScreen.composables

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import com.fighter.githubexplore.presentation.ui.theme.Theme

fun Modifier.noRippleEffect(onClick: () -> Unit) = composed {
    clickable(
        interactionSource = remember { MutableInteractionSource() },
        indication = null,
        onClick = onClick
    )
}

fun Modifier.shimmerEffect(durationMillis: Int = 1000): Modifier = composed {
    composed {
        composed {
            var size by remember { mutableStateOf(IntSize.Zero) }
            val transition = rememberInfiniteTransition(label = "")
            val startOffset by transition.animateFloat(
                initialValue = -2 * size.width.toFloat(),
                targetValue = 2 * size.width.toFloat(),
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis),
                ),
                label = "",
            )

            background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Theme.colors.disable,
                        Theme.colors.disable.copy(alpha = 0.5f),
                        Theme.colors.disable,
                    ),
                    start = Offset(startOffset, 0f),
                    end = Offset(startOffset + size.width, size.height.toFloat()),
                )
            ).onGloballyPositioned { size = it.size }
        }
    }
}