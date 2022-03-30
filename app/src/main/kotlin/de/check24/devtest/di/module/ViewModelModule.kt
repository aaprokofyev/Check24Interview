package de.check24.devtest.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import de.check24.devtest.di.ViewModelFactory
import de.check24.devtest.di.ViewModelKey
import de.check24.devtest.ui.productlist.ProductListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import de.check24.devtest.ui.productdetails.ProductDetailsViewModel

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProductListViewModel::class)
    abstract fun bindProductListViewModel(productListViewModel: ProductListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProductDetailsViewModel::class)
    abstract fun bindProductDetailsViewModel(productDetailsViewModel: ProductDetailsViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}
