package com.fighter.githubexplore.domain.entity

data class Repository(
    val repoName: String,
    val fullName: String,
    val owner: RepositoryOwner,
)