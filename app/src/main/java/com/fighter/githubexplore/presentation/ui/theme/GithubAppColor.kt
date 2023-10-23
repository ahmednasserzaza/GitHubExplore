package com.fighter.githubexplore.presentation.ui.theme

import androidx.compose.ui.graphics.Color

data class GithubAppColor(
    val primary: Color,
    val onPrimary: Color,
    val background: Color,
)

val LightColors = GithubAppColor(
    primary = Color(0xFF2196F3),
    background = Color(0xFFFAFAFA),
    onPrimary = Color(0xFFFFFFFF)
)

val DarkColors = GithubAppColor(
    primary = Color(0xFF2196F3),
    background = Color(0xFF151515),
    onPrimary = Color(0xFFFFECEC)
)