package com.docusketch.data.remote.datasource

import com.docusketch.common.utils.network.NetworkStatus
import com.docusketch.data.remote.api.RepositoryApiService
import com.docusketch.data.utils.safeApiCall
import com.docusketch.domain.model.ApiRepository

internal class RepositoryRemoteDataSourceImpl(private val repositoryApiService: RepositoryApiService) :
    RepositoryRemoteDataSource {

    override suspend fun getAllRepositoriesForUser(userName: String): NetworkStatus<List<ApiRepository>> {
        return safeApiCall { repositoryApiService.getUserRepos(userName) }
    }
}