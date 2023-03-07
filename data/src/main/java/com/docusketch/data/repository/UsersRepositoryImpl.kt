package com.docusketch.data.repository

import com.docusketch.common.utils.network.NetworkStatus
import com.docusketch.data.local.datasource.UserLocalDataSource
import com.docusketch.data.mappers.map
import com.docusketch.data.remote.datasource.UserRemoteDataSource
import com.docusketch.data.utils.networkBoundResource
import com.docusketch.domain.entites.DbUser
import com.docusketch.domain.repository.UsersRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UsersRepositoryImpl(
    private val remoteDataSource: UserRemoteDataSource,
    private val localDataSource: UserLocalDataSource
) : UsersRepository {

    @ExperimentalCoroutinesApi
    override suspend fun getAllUsers(since: Int): Flow<NetworkStatus<List<DbUser>>> {
        return networkBoundResource(
            query = { queryLocalUsers() },
            fetch = { remoteDataSource.getAllUsers(since) },
            saveFetchResult = { response ->
                response.data?.let {
                    val users = it.map { user ->
                        user.map()
                    }
                    localDataSource.saveUsers(users)
                }
            },
            clearData = {}
        )
    }

    @ExperimentalCoroutinesApi
    override suspend fun getUserDetails(userName: String): Flow<NetworkStatus<DbUser>>  = networkBoundResource(
        query = { queryLocalUser(userName) },
        fetch = { remoteDataSource.getUserDetails(userName) },
        saveFetchResult = { response ->
            response.data?.let {
                localDataSource.saveUsers(listOf(it.map()))
            }
        },
        clearData = {}
    )

    private fun queryLocalUsers(): Flow<List<DbUser>> = flow {
        emit(localDataSource.getAllUsers())
    }

    private fun queryLocalUser(userName: String): Flow<DbUser> = flow {
        emit(localDataSource.getUser(userName))
    }
}