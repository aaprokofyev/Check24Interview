package de.check24.devtest.di.module

import de.check24.devtest.ui.productlist.ProductListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentsModule {

    @ContributesAndroidInjector
    abstract fun contributeProductListFragment(): ProductListFragment

}
