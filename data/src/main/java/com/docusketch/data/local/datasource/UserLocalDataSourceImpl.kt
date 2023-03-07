package com.docusketch.data.local.datasource

import com.docusketch.data.local.dao.UserDao
import com.docusketch.domain.entites.DbUser

internal class UserLocalDataSourceImpl(private val userDao: UserDao) : UserLocalDataSource {

    override suspend fun saveUsers(users: List<DbUser>) {
        userDao.insertUsers(users)
    }

    override suspend fun getAllUsers(): List<DbUser> {
        return userDao.queryUsers()
    }

    override suspend fun getUser(username: String): DbUser {
        return userDao.queryUser(username)
    }
}