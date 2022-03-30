package de.check24.devtest.di

import de.check24.devtest.Check24Application
import de.check24.devtest.di.component.AppComponent
import de.check24.devtest.di.component.DaggerAppComponent

object AppInjector {
    lateinit var appComponent: AppComponent
        private set

    fun init(application: Check24Application) {
        appComponent = DaggerAppComponent
            .builder()
            .application(application)
            .build()
        appComponent
            .inject(application)
    }
}