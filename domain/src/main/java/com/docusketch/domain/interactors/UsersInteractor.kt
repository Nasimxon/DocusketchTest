package com.docusketch.domain.interactors

import com.docusketch.common.utils.network.NetworkStatus
import com.docusketch.domain.entites.DbUser
import com.docusketch.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UsersInteractor @Inject constructor(
    private val usersRepository: UsersRepository
) {

   suspend fun getUsers(since: Int = 1) : Flow<NetworkStatus<List<DbUser>>> {
       return usersRepository.getAllUsers(since)
   }

    suspend fun getUserDetails(username: String) : Flow<NetworkStatus<DbUser>> {
        return usersRepository.getUserDetails(username)
    }
}