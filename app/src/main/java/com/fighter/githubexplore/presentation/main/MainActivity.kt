package com.fighter.githubexplore.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.fighter.githubexplore.presentation.repositoryScreen.RepositoryScreen
import com.fighter.githubexplore.presentation.ui.theme.GitHubExploreTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitHubExploreTheme {
                RepositoryScreen()
            }
        }
    }
}