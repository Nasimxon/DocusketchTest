package com.docusketch.details.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.docusketch.common.scopes.Fragment
import com.docusketch.common.scopes.ViewModelKey
import com.docusketch.presentation.factory.ViewModelFactory
import com.docusketch.presentation.viewmodel.UserDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface UserDetailsViewModelModule {

    @Binds
    @Fragment
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(UserDetailsViewModel::class)
    fun bindViewModel(viewModel: UserDetailsViewModel): ViewModel

}
