package com.fighter.githubexplore.data.remote.service

import com.fighter.githubexplore.data.remote.model.RepositoryDetailsDto
import com.fighter.githubexplore.data.remote.model.RepositoryDto
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("repositories")
    suspend fun getRepositories(): List<RepositoryDto>

    @GET("repos/{ownerName}/{repoName}")
    suspend fun getRepositoryDetails(
        @Path("ownerName") ownerName: String,
        @Path("repoName") repoName: String,
    ): RepositoryDetailsDto
}