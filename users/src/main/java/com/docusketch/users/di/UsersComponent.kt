package com.docusketch.users.di

import com.docusketch.common.scopes.Fragment
import com.docusketch.core.di.CoreComponent
import com.docusketch.users.ui.UsersFragment
import dagger.Component

@Component(dependencies = [CoreComponent::class],
    modules = [UsersViewModelModule::class]
)
@Fragment
interface UsersComponent {
    fun inject(usersFragment: UsersFragment)

    @Component.Factory
    interface Factory {
        fun create(component: CoreComponent): UsersComponent
    }
}