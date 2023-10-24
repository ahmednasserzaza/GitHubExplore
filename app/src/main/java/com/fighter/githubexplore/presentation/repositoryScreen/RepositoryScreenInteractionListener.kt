package com.fighter.githubexplore.presentation.repositoryScreen

interface RepositoryScreenInteractionListener {
    fun onRepositoryClicked(ownerName: String, repoName: String)
    fun onExitClicked()
}