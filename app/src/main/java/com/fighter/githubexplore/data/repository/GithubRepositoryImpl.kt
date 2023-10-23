package com.fighter.githubexplore.data.repository

import com.fighter.githubexplore.data.remote.GithubService
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(private val api: GithubService) : GithubRepository {

}