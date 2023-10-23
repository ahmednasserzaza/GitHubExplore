package com.fighter.githubexplore.data.repository

import com.fighter.githubexplore.data.remote.RepositoryDto

data class Repository(
    val fullName: String,
    val description: String?,
    val stargazersCount: Int,
    val createdAt: String,
    val login: String,
    val avatarUrl: String,
)

fun RepositoryDto.toEntity(): Repository {
    return Repository(
        fullName = fullName,
        description = description,
        stargazersCount = stargazersCount,
        createdAt = createdAt,
        login = owner.login,
        avatarUrl = owner.avatarUrl
    )
}
