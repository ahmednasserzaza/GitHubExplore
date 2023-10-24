package com.fighter.githubexplore.presentation.repositoryScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
) : ViewModel() {

    private val _state = MutableStateFlow(RepositoryScreenUiState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            getRepositories()
        }
    }

    private suspend fun getRepositories() {
        _state.update { it.copy(isLoading = true) }
        try {
            val repositories = repository.getRepositories()
            _state.update { repositoryUiState ->
                repositoryUiState.copy(
                    isLoading = false,
                    repositories = repositories.toUiState()
                )
            }
        } catch (e: Exception) {
            _state.update { it.copy(isLoading = false, error = e.message.toString()) }
        }
    }

    private suspend fun getRepositoryDetails(repoName: String, ownerName: String) {
        _state.update { it.copy(isLoading = true) }
        try {
            val repositoryDetails = repository.getRepositoryDetails(ownerName, repoName)
            _state.update { repositoryUiState ->
                repositoryUiState.copy(
                    isLoading = false,
                    repositoryDetails = repositoryDetails.toUiState()
                )
            }
        } catch (e: Exception) {
            _state.update { it.copy(isLoading = false, error = e.message.toString()) }
        }
    }

}