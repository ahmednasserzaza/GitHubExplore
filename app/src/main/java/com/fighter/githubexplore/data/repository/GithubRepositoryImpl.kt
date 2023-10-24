package com.fighter.githubexplore.data.repository

import com.fighter.githubexplore.data.remote.GithubService
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(private val api: GithubService) : GithubRepository {
    override suspend fun getRepositories(): List<Repository> {
//        return api.getRepositories().map { it.toEntity() }
        return api.getRepositories().take(10).map {
            api.getRepositoryInfo(it.owner.login, it.repoName).toEntity()
        }
    }
}