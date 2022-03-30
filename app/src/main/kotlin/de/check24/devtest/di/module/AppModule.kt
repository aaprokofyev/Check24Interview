package de.check24.devtest.di.module

import android.app.Application
import android.content.Context
import de.check24.devtest.domain.repository.ProductsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {
    @Provides
    @Singleton
    fun context(app: Application): Context = app.applicationContext

    @Provides
    @Singleton
    fun provideProductsRepository(productsRepository: de.check24.devtest.data.repository.ProductsRepository): ProductsRepository =
        productsRepository
}