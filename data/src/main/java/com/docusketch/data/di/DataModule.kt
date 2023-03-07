package com.docusketch.data.di

import com.docusketch.data.coroutines.DefaultDispatcherProvider
import com.docusketch.data.coroutines.DispatcherProvider
import com.docusketch.data.local.dao.RepositoryDao
import com.docusketch.data.local.dao.UserDao
import com.docusketch.data.local.datasource.RepositoryLocalDataSource
import com.docusketch.data.local.datasource.RepositoryLocalDataSourceImpl
import com.docusketch.data.local.datasource.UserLocalDataSource
import com.docusketch.data.local.datasource.UserLocalDataSourceImpl
import com.docusketch.data.remote.api.RepositoryApiService
import com.docusketch.data.remote.api.UsersApiService
import com.docusketch.data.remote.datasource.RepositoryRemoteDataSource
import com.docusketch.data.remote.datasource.RepositoryRemoteDataSourceImpl
import com.docusketch.data.remote.datasource.UserRemoteDataSource
import com.docusketch.data.remote.datasource.UserRemoteDataSourceImpl
import com.docusketch.data.repository.UserReposRepositoryImpl
import com.docusketch.data.repository.UsersRepositoryImpl
import com.docusketch.domain.repository.UserReposRepository
import com.docusketch.domain.repository.UsersRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class DataModule {

    @Provides
    @Singleton
    internal fun provideDispatcherProvider(): DispatcherProvider = DefaultDispatcherProvider()

    @Provides
    fun provideUserRemoteDataSource(usersApiService: UsersApiService): UserRemoteDataSource {
        return UserRemoteDataSourceImpl(usersApiService)
    }

    @Provides
    fun provideUserLocalDataSource(userDao: UserDao): UserLocalDataSource {
        return UserLocalDataSourceImpl(userDao)
    }

    @Provides
    fun provideRepositoryRemoteDataSource(repositoryApiService: RepositoryApiService): RepositoryRemoteDataSource {
        return RepositoryRemoteDataSourceImpl(repositoryApiService)
    }

    @Provides
    fun provideRepositoryLocalDataSource(repositoryDao: RepositoryDao): RepositoryLocalDataSource {
        return RepositoryLocalDataSourceImpl(repositoryDao)
    }

    @Singleton
    @Provides
    fun provideUsersRepository(
        dispatcherProvider: DispatcherProvider,
        userRemoteDataSource: UserRemoteDataSource,
        userLocalDataSource: UserLocalDataSource
    ): UsersRepository {
        return UsersRepositoryImpl(userRemoteDataSource, userLocalDataSource)
    }

    @Singleton
    @Provides
    fun provideUserReposRepository(
        remoteDataSource: RepositoryRemoteDataSource,
        localDataSource: RepositoryLocalDataSource
    ): UserReposRepository {
        return UserReposRepositoryImpl(remoteDataSource, localDataSource)
    }

}