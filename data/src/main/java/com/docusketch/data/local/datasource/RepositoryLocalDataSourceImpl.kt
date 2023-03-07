package com.docusketch.data.local.datasource

import com.docusketch.data.local.dao.RepositoryDao
import com.docusketch.domain.entites.DbRepository

internal class RepositoryLocalDataSourceImpl(private val repositoryDao: RepositoryDao) : RepositoryLocalDataSource {

    override suspend fun saveRepositories(repos: List<DbRepository>) {
        repositoryDao.insertRepositories(repos)
    }

    override suspend fun getAllRepositories(): List<DbRepository> {
        return repositoryDao.queryRepositories()
    }
}