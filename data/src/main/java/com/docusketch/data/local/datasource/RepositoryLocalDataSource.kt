package com.docusketch.data.local.datasource

import com.docusketch.domain.entites.DbRepository

interface RepositoryLocalDataSource {

    suspend fun saveRepositories(repos: List<DbRepository>)

    suspend fun getAllRepositories(): List<DbRepository>

}