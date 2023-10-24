package com.fighter.githubexplore.presentation.repositoryScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fighter.githubexplore.domain.entity.Repository
import com.fighter.githubexplore.domain.entity.RepositoryDetails
import com.fighter.githubexplore.domain.repository.GithubRepository
import com.fighter.githubexplore.presentation.repositoryScreen.mapper.toUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepositoryViewModel @Inject constructor(
    private val repository: GithubRepository,
) : ViewModel(), RepositoryScreenInteractionListener {

    private val _state = MutableStateFlow(RepositoryScreenUiState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            getRepositories()
        }
    }

    private suspend fun <T> tryToExecute(
        function: suspend () -> T,
        onSuccess: suspend (T) -> Unit,
        onError: (String) -> Unit,
    ) {
        try {
            val result = function()
            onSuccess(result)
        } catch (e: Exception) {
            onError(e.message.toString())
        }
    }

    private suspend fun getRepositories() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            function = { repository.getRepositories() },
            onSuccess = ::onGetRepositoriesSuccess,
            onError = ::onError
        )
    }

    private suspend fun getRepositoryDetails(repoName: String, ownerName: String) {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            function = { repository.getRepositoryDetails(ownerName, repoName) },
            onSuccess = ::onGetRepositoryDetailsSuccess,
            onError = ::onError
        )
    }

    private fun onGetRepositoriesSuccess(repositories: List<Repository>) {
        _state.update { repositoryUiState ->
            repositoryUiState.copy(
                isLoading = false,
                repositories = repositories.toUiState()
            )
        }
    }

    private fun onGetRepositoryDetailsSuccess(repositoryDetails: RepositoryDetails) {
        _state.update { repositoryUiState ->
            repositoryUiState.copy(
                isLoading = false,
                repositoryDetails = repositoryDetails.toUiState(),
                showRepositoryDetails = true
            )
        }
    }

    private fun onError(error: String) {
        _state.update { it.copy(isLoading = false, error = error) }
    }

    override fun onRepositoryClicked(ownerName: String, repoName: String) {
        viewModelScope.launch {
            getRepositoryDetails(repoName, ownerName)
        }
    }

    override fun onExitClicked() {
        _state.update { it.copy(showRepositoryDetails = false) }
    }
}