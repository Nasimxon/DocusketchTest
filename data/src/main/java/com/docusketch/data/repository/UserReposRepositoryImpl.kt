package com.docusketch.data.repository

import com.docusketch.common.utils.network.NetworkStatus
import com.docusketch.data.coroutines.DispatcherProvider
import com.docusketch.data.local.datasource.RepositoryLocalDataSource
import com.docusketch.data.mappers.map
import com.docusketch.data.remote.datasource.RepositoryRemoteDataSource
import com.docusketch.data.utils.networkBoundResource
import com.docusketch.domain.entites.DbRepository
import com.docusketch.domain.repository.UserReposRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserReposRepositoryImpl(
    private val remoteDataSource: RepositoryRemoteDataSource,
    private val localDataSource: RepositoryLocalDataSource
) : UserReposRepository {

    @ExperimentalCoroutinesApi
    override suspend fun getReposForUser(userName: String): Flow<NetworkStatus<List<DbRepository>>> {
        return networkBoundResource(
            query = { queryLocalRepos() },
            fetch = { remoteDataSource.getAllRepositoriesForUser(userName) },
            saveFetchResult = { response ->
                response.data?.let {
                    val repos = it.map { repo ->
                        repo.map()
                    }
                    localDataSource.saveRepositories(repos)
                }
            },
            clearData = {}
        )
    }

    private fun queryLocalRepos(): Flow<List<DbRepository>> = flow {
        emit(localDataSource.getAllRepositories())
    }
}