package com.docusketch.core

import android.app.Application
import android.content.Context
import com.docusketch.core.di.CoreComponent
import com.docusketch.core.di.DaggerCoreComponent

class App: Application() {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(this)
    }

    companion object {
        @JvmStatic
        fun coreComponent(context: Context) = (context.applicationContext as App).coreComponent
    }

}