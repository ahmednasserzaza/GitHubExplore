package com.fighter.githubexplore.presentation.ui.theme

import androidx.compose.ui.graphics.Color

data class GithubAppColor(
    val primary: Color,
    val secondary: Color,
    val onPrimary: Color,
    val background: Color,
    val onSurface: Color,
    val hint: Color,
    val disable: Color,
    val tertiary: Color,
)

val LightColors = GithubAppColor(
    primary = Color(0xFF2196F3),
    secondary = Color(0xFFFFFFFF),
    background = Color(0xFAFAFAFA),
    onPrimary = Color(0xFFFFFFFF),
    onSurface = Color(0xDE000000),
    hint = Color(0xB3000000),
    disable = Color(0x402196F3),
    tertiary = Color(0xFFCACACA),
)

val DarkColors = GithubAppColor(
    primary = Color(0xFF006ABE),
    secondary = Color(0xFF222222),
    background = Color(0xFF1D1D1D),
    onPrimary = Color(0xFFFFECEC),
    onSurface = Color(0xDEFFFFFF),
    hint = Color(0x99FFFFFF),
    disable = Color(0x40A3A3A3),
    tertiary = Color(0xFF141414),
)