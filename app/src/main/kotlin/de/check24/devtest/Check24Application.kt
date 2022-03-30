package de.check24.devtest

import android.app.Application
import de.check24.devtest.di.AppInjector

class Check24Application : Application() {
    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }
}