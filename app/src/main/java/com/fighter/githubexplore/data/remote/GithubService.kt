package com.fighter.githubexplore.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("repositories")
    suspend fun getRepositories(): List<RepositoryDto>

    @GET("repos/{fullName}")
    suspend fun getRepositoryInfo(@Path("fullName") fullName: String): RepositoryDto
}