package com.docusketch.domain.repository

import com.docusketch.common.utils.network.NetworkStatus
import com.docusketch.domain.entites.DbUser
import kotlinx.coroutines.flow.Flow

interface UsersRepository {

    suspend fun getAllUsers(since: Int): Flow<NetworkStatus<List<DbUser>>>

    suspend fun getUserDetails(userName: String): Flow<NetworkStatus<DbUser>>

}