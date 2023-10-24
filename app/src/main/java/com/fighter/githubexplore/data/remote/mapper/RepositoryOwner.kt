package com.fighter.githubexplore.data.remote.mapper

import com.fighter.githubexplore.data.remote.model.RepositoryOwnerDto
import com.fighter.githubexplore.domain.entity.RepositoryOwner

fun RepositoryOwnerDto.toEntity(): RepositoryOwner {
    return RepositoryOwner(
        ownerName = ownerName,
        avatarUrl = avatarUrl
    )
}