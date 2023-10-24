package com.fighter.githubexplore.data.remote.mapper

import com.fighter.githubexplore.data.remote.model.RepositoryDto
import com.fighter.githubexplore.domain.entity.Repository

fun RepositoryDto.toEntity(): Repository {
    return Repository(
        repoName = repoName,
        fullName = fullName,
        owner = owner.toEntity()
    )
}

fun List<RepositoryDto>.toEntity(): List<Repository> {
    return map { it.toEntity() }
}