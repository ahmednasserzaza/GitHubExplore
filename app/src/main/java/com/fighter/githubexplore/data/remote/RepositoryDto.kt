package com.fighter.githubexplore.data.remote

import com.google.gson.annotations.SerializedName

data class RepositoryDto(
    @SerializedName("full_name") val fullName: String,
    @SerializedName("owner") val owner: OwnerDto,
    @SerializedName("description") val description: String?,
    @SerializedName("stargazers_count") val stargazersCount: Int,
    @SerializedName("created_at") val createdAt: String,
) {
    data class OwnerDto(
        @SerializedName("login") val login: String,
        @SerializedName("avatar_url") val avatarUrl: String,
    )
}