package com.fighter.githubexplore.presentation.homeScreen

import com.fighter.githubexplore.data.repository.Repository

data class RepositoryUiState(
    val isLoading: Boolean = false,
    val repositories: List<RepositoryInfoUiState> = emptyList(),
    val error: String = "",
)

data class RepositoryInfoUiState(
    val repositoryName: String = "",
    val description: String = "",
    val starsCount: Int = 0,
    val createdAt: String = "",
    val ownerName: String = "",
    val imageUrl: String = "",
)


fun Repository.toUiState(): RepositoryInfoUiState {
    return RepositoryInfoUiState(
        repositoryName = repoName,
        description = description,
        starsCount = stargazersCount,
        createdAt = createdAt,
        ownerName = login,
        imageUrl = avatarUrl
    )
}