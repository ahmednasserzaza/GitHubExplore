package com.fighter.githubexplore.data.repository

import com.fighter.githubexplore.data.remote.RepositoryDto
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.periodUntil
import kotlinx.datetime.toLocalDateTime

data class Repository(
    val repoName: String,
    val description: String,
    val stargazersCount: Int,
    val createdAt: String,
    val login: String,
    val avatarUrl: String,
)

fun RepositoryDto.toEntity(): Repository {
    return Repository(
        repoName = repoName,
        description = description ?: "",
        stargazersCount = stargazersCount,
        createdAt = formatCreationDate(createdAt),
        login = owner.login,
        avatarUrl = owner.avatarUrl
    )
}

fun formatCreationDate(apiDateString: String): String {
    val apiDateInstant = Instant.parse(apiDateString)
    val currentInstant = Clock.System.now()
    val period = apiDateInstant.periodUntil(currentInstant, TimeZone.UTC)

    return when {
        period.months >= 6 -> {
            apiDateInstant.toLocalDateTime(TimeZone.UTC).run {
                "${dayOfWeek.name}, ${month.name} $dayOfMonth, $year"
            }
        }

        period.months >= 1 -> "${period.months} months ago"
        else -> "${period.years} years ago"
    }
}