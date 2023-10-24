package com.fighter.githubexplore.di

import com.fighter.githubexplore.data.remote.service.GithubService
import com.fighter.githubexplore.domain.repository.GithubRepository
import com.fighter.githubexplore.domain.repository.GithubRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule() {

    @Singleton
    @Provides
    fun provideGithubRepository(githubService: GithubService): GithubRepository {
        return GithubRepositoryImpl(githubService)
    }
}