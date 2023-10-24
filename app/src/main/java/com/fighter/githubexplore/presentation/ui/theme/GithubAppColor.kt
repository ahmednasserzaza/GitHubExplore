package com.fighter.githubexplore.presentation.ui.theme

import androidx.compose.ui.graphics.Color

data class GithubAppColor(
    val primary: Color,
    val secondary:Color,
    val onPrimary: Color,
    val background: Color,
    val onSurface: Color,
    val hint: Color
)

val LightColors = GithubAppColor(
    primary = Color(0xFF2196F3),
    secondary = Color(0xFFFFFFFF),
    background = Color(0xFAFAFAFA),
    onPrimary = Color(0xFFFFFFFF),
    onSurface = Color(0xDE000000),
    hint = Color(0xB3000000)
)

val DarkColors = GithubAppColor(
    primary = Color(0xFF2196F3),
    secondary = Color(0xFFFFFFFF),
    background = Color(0xFF151515),
    onPrimary = Color(0xFFFFECEC),
    onSurface = Color(0xDE000000),
    hint = Color(0xB3000000)
)