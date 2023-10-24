package com.fighter.githubexplore.domain.repository

import com.fighter.githubexplore.domain.entity.Repository
import com.fighter.githubexplore.domain.entity.RepositoryDetails

interface GithubRepository {
    suspend fun getRepositories(): List<Repository>
    suspend fun getRepositoryDetails(ownerName: String, repoName: String): RepositoryDetails
}