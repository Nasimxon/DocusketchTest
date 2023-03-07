package com.docusketch.data.remote.datasource

import com.docusketch.common.utils.network.NetworkStatus
import com.docusketch.domain.model.ApiUser

interface UserRemoteDataSource {

    suspend fun getAllUsers(since: Int): NetworkStatus<List<ApiUser>>

    suspend fun getUserDetails(userName: String): NetworkStatus<ApiUser>

}