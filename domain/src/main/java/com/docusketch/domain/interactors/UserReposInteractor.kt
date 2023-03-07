package com.docusketch.domain.interactors

import com.docusketch.common.utils.network.NetworkStatus
import com.docusketch.domain.entites.DbRepository
import com.docusketch.domain.repository.UserReposRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserReposInteractor @Inject constructor(
    private val userReposRepository: UserReposRepository
) {
    suspend fun getUserRepositories(username: String): Flow<NetworkStatus<List<DbRepository>>> {
        return userReposRepository.getReposForUser(username)
    }
}