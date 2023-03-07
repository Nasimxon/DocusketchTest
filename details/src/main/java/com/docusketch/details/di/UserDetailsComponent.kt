package com.docusketch.details.di

import com.docusketch.common.scopes.Fragment
import com.docusketch.core.di.CoreComponent
import com.docusketch.details.ui.UserDetailsFragment
import dagger.Component

@Component(dependencies = [CoreComponent::class],
    modules = [UserDetailsViewModelModule::class]
)
@Fragment
interface UserDetailsComponent {
    fun inject(userDetailsFragment: UserDetailsFragment)

    @Component.Factory
    interface Factory {
        fun create(component: CoreComponent): UserDetailsComponent
    }
}