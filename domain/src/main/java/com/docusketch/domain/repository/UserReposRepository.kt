package com.docusketch.domain.repository

import com.docusketch.common.utils.network.NetworkStatus
import com.docusketch.domain.entites.DbRepository
import kotlinx.coroutines.flow.Flow

interface UserReposRepository {

    suspend fun getReposForUser(userName: String): Flow<NetworkStatus<List<DbRepository>>>

}