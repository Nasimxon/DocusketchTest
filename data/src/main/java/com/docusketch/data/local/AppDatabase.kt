package com.docusketch.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.docusketch.data.local.dao.RepositoryDao
import com.docusketch.data.local.dao.UserDao
import com.docusketch.domain.entites.DbRepository
import com.docusketch.domain.entites.DbUser

@Database(entities = [DbUser::class, DbRepository::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun repositoryDao(): RepositoryDao

    companion object {
        const val DATABASE_NAME = "docusketch_app_db"
    }
}
