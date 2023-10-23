package com.fighter.githubexplore.presentation.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fighter.githubexplore.data.repository.GithubRepository
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

    private val _state = MutableStateFlow(RepositoryUiState())
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
                    repositories = repositories.map { it.toUiState() })
            }
        } catch (e: Exception) {
            _state.update { it.copy(isLoading = false, error = e.message.toString()) }
        }
    }

}