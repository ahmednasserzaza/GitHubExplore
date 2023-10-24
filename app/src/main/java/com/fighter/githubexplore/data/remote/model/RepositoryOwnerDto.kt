package com.fighter.githubexplore.data.remote.model

import com.google.gson.annotations.SerializedName

data class RepositoryOwnerDto(
    @SerializedName("id") val id: Int,
    @SerializedName("login") val ownerName: String,
    @SerializedName("avatar_url") val avatarUrl: String,
)