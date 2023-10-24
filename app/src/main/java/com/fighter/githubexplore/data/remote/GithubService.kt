package com.fighter.githubexplore.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("repositories")
    suspend fun getRepositories(): List<RepositoryDto>

    @GET("repos/{ownerName}/{repoName}")
    suspend fun getRepositoryInfo(
        @Path("ownerName") ownerName: String,
        @Path("repoName") repoName: String,
    ): RepositoryDto
}