package com.fighter.githubexplore.presentation.repositoryScreen

data class RepositoryScreenUiState(
    val isLoading: Boolean = false,
    val repositories: List<RepositoryUiState> = emptyList(),
    val repositoryDetails: RepositoryDetailsUiState = RepositoryDetailsUiState(),
    val error: String = "",
)

data class RepositoryUiState(
    val repoName: String,
    val fullName: String,
    val owner: RepositoryOwnerUiState,
)

data class RepositoryOwnerUiState(
    val ownerName: String = "",
    val avatarUrl: String = "",
)

data class RepositoryDetailsUiState(
    val repoName: String = "",
    val owner: RepositoryOwnerUiState = RepositoryOwnerUiState(),
    val description: String = "",
    val starsCount: Int = 0,
    val createdAt: String = "",
)