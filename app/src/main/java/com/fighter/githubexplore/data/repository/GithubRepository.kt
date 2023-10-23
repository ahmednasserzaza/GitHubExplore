package com.fighter.githubexplore.data.repository

interface GithubRepository {
    suspend fun getRepositories(): List<Repository>
}