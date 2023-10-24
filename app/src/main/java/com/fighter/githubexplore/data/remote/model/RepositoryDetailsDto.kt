package com.fighter.githubexplore.data.remote.model

import com.google.gson.annotations.SerializedName

data class RepositoryDetailsDto(
    @SerializedName("name") val repoName: String,
    @SerializedName("owner") val owner: RepositoryOwnerDto,
    @SerializedName("description") val description: String?,
    @SerializedName("stargazers_count") val stargazersCount: Int,
    @SerializedName("created_at") val createdAt: String,
)