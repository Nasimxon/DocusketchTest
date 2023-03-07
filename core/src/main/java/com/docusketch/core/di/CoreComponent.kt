package com.docusketch.core.di

import android.content.Context
import com.docusketch.core.di.modules.CoreModule
import com.docusketch.core.di.modules.DatabaseModule
import com.docusketch.data.di.DataModule
import com.docusketch.domain.repository.UserReposRepository
import com.docusketch.domain.repository.UsersRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class, DatabaseModule::class, DataModule::class])
interface CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): CoreComponent
    }

    val usersRepository: UsersRepository
    val userReposRepository: UserReposRepository
}