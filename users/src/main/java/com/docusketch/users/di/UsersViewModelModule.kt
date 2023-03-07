package com.docusketch.users.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.docusketch.common.scopes.Fragment
import com.docusketch.common.scopes.ViewModelKey
import com.docusketch.presentation.factory.ViewModelFactory
import com.docusketch.presentation.viewmodel.UsersViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface UsersViewModelModule {

    @Binds
    @Fragment
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(UsersViewModel::class)
    fun bindViewModel(viewModel: UsersViewModel): ViewModel

}
