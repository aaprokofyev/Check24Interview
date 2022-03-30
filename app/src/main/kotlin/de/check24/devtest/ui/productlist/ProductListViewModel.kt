package de.check24.devtest.ui.productlist

import androidx.lifecycle.*
import de.check24.devtest.domain.interactor.GetProductList
import de.check24.devtest.domain.model.Product
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class ProductListViewModel @Inject constructor(
    private val getProductList: GetProductList
) : ViewModel() {

    private val _products = MutableLiveData<List<Product>>(emptyList())
    val products: LiveData<List<Product>>
        get() = _products

    private val _loadError = MutableLiveData(false)
    val loadError: LiveData<Boolean>
        get() = _loadError

    init {
        getProducts()
    }

    fun getProducts() {
        viewModelScope.launch {
            try {
                _products.value = getProductList.execute(Unit)
                _loadError.value = false
            } catch (ex: Exception) {
                _loadError.value = true //smth goes wrong (:
            }
        }
    }
}