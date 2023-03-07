package com.docusketch.data.remote.datasource

import com.docusketch.common.utils.network.NetworkStatus
import com.docusketch.domain.model.ApiRepository

interface RepositoryRemoteDataSource {

    suspend fun getAllRepositoriesForUser(userName: String): NetworkStatus<List<ApiRepository>>

}