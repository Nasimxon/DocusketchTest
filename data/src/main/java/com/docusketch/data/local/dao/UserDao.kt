package com.docusketch.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.docusketch.domain.entites.DbUser

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(users: List<DbUser>)

    @Query("SELECT * FROM DbUser")
    suspend fun queryUsers(): List<DbUser>

    @Query("SELECT * FROM DbUser WHERE login=:username")
    suspend fun queryUser(username: String): DbUser
}
