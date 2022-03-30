package de.check24.devtest.ui.productdetails

import androidx.lifecycle.*
import de.check24.devtest.domain.model.Product
import javax.inject.Inject

class ProductDetailsViewModel @Inject constructor() : ViewModel() {

    private val _product = MutableLiveData<Product>()
    val product: LiveData<Product>
        get() = _product

    private val _loadError = MutableLiveData(false)
    val loadError: LiveData<Boolean>
        get() = _loadError


    fun setProduct(product: Product) {
        _product.value = product
    }
}