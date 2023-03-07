package com.docusketch.core.di.modules

import android.content.Context
import androidx.room.Room
import com.docusketch.data.local.AppDatabase
import com.docusketch.data.local.AppDatabase.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(context: Context): AppDatabase = Room.databaseBuilder(
        context, AppDatabase::class.java, DATABASE_NAME)
        .fallbackToDestructiveMigration()
        .build()

    @Singleton
    @Provides
    fun provideUsersDao(appDatabase: AppDatabase) = appDatabase.userDao()

    @Singleton
    @Provides
    fun provideRepositoryDao(appDatabase: AppDatabase) = appDatabase.repositoryDao()
}