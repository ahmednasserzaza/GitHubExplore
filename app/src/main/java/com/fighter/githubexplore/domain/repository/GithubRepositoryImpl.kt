package com.fighter.githubexplore.domain.repository

import com.fighter.githubexplore.data.remote.mapper.toEntity
import com.fighter.githubexplore.data.remote.service.GithubService
import com.fighter.githubexplore.domain.entity.Repository
import com.fighter.githubexplore.domain.entity.RepositoryDetails
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(private val api: GithubService) : GithubRepository {
    override suspend fun getRepositories(): List<Repository> {
        return api.getRepositories().toEntity()
    }

    override suspend fun getRepositoryDetails(
        ownerName: String,
        repoName: String,
    ): RepositoryDetails {
        return api.getRepositoryDetails(ownerName, repoName).toEntity()
    }
}