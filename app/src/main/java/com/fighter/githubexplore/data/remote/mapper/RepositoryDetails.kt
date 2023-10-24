package com.fighter.githubexplore.data.remote.mapper

import com.fighter.githubexplore.data.remote.model.RepositoryDetailsDto
import com.fighter.githubexplore.domain.entity.RepositoryDetails

fun RepositoryDetailsDto.toEntity(): RepositoryDetails {
    return RepositoryDetails(
        repoName = repoName,
        owner = owner.toEntity(),
        description = description ?: "There is no description for this repository",
        starsCount = stargazersCount,
        createdAt = createdAt
    )
}