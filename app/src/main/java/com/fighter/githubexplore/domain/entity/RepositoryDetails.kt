package com.fighter.githubexplore.domain.entity

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.periodUntil
import kotlinx.datetime.toLocalDateTime

data class RepositoryDetails(
    val repoName: String,
    val owner: RepositoryOwner,
    val description: String,
    val starsCount: Int,
    val createdAt: String,
) {
    val createdAtFormat = formatCreationDate(createdAt)
}

private fun formatCreationDate(apiDateString: String): String {
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