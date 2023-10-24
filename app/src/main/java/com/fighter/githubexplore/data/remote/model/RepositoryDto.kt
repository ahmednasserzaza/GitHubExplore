package com.fighter.githubexplore.data.remote.model

import com.google.gson.annotations.SerializedName

data class RepositoryDto(
    @SerializedName("name") val repoName: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("owner") val owner: RepositoryOwnerDto,
)