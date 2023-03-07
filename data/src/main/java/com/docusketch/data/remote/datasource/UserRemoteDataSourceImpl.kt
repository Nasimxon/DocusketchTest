package com.docusketch.data.remote.datasource

import com.docusketch.common.utils.network.NetworkStatus
import com.docusketch.data.remote.api.UsersApiService
import com.docusketch.data.utils.safeApiCall
import com.docusketch.domain.model.ApiUser

class UserRemoteDataSourceImpl (private val usersApiService: UsersApiService): UserRemoteDataSource {
    override suspend fun getAllUsers(since: Int): NetworkStatus<List<ApiUser>> {
        return safeApiCall { usersApiService.getAllUsers(since) }
    }

    override suspend fun getUserDetails(userName: String): NetworkStatus<ApiUser> {
        return safeApiCall { usersApiService.getUserInfo(userName) }
    }
}