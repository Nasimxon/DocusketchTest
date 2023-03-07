package com.docusketch.data.local.datasource

import com.docusketch.domain.entites.DbUser


interface UserLocalDataSource {

    suspend fun saveUsers(users: List<DbUser>)

    suspend fun getAllUsers(): List<DbUser>

    suspend fun getUser(username: String): DbUser

}