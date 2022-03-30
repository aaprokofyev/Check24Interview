package de.check24.devtest.di.component

import android.app.Application
import de.check24.devtest.Check24Application
import de.check24.devtest.di.module.ActivityModule
import de.check24.devtest.di.module.AppModule
import de.check24.devtest.di.module.NetworkModule
import de.check24.devtest.ui.productlist.ProductListFragment
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import de.check24.devtest.ui.productdetails.ProductDetailsFragment
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        NetworkModule::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: Check24Application)
    fun inject(fragment: ProductListFragment)
    fun inject(fragment: ProductDetailsFragment)
}