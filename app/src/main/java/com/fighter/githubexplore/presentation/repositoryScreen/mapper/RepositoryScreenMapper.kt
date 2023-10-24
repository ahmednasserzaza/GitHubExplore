package com.fighter.githubexplore.presentation.repositoryScreen.mapper

import com.fighter.githubexplore.domain.entity.Repository
import com.fighter.githubexplore.domain.entity.RepositoryDetails
import com.fighter.githubexplore.domain.entity.RepositoryOwner
import com.fighter.githubexplore.presentation.repositoryScreen.RepositoryDetailsUiState
import com.fighter.githubexplore.presentation.repositoryScreen.RepositoryOwnerUiState
import com.fighter.githubexplore.presentation.repositoryScreen.RepositoryUiState

fun Repository.toUiState(): RepositoryUiState {
    return RepositoryUiState(
        repoName = repoName,
        fullName = fullName,
        owner = owner.toUiState()
    )
}

fun RepositoryOwner.toUiState(): RepositoryOwnerUiState {
    return RepositoryOwnerUiState(
        ownerName = ownerName,
        avatarUrl = avatarUrl
    )
}

fun RepositoryDetails.toUiState(): RepositoryDetailsUiState {
    return RepositoryDetailsUiState(
        repoName = repoName,
        owner = owner.toUiState(),
        description = description,
        starsCount = starsCount,
        createdAt = createdAtFormat
    )
}

fun List<Repository>.toUiState(): List<RepositoryUiState> {
    return map { it.toUiState() }
}