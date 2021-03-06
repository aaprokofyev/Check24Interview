package de.check24.devtest.ui.productlist

import androidx.lifecycle.*
import de.check24.devtest.domain.interactor.GetProductList
import de.check24.devtest.domain.interactor.ProductListData
import de.check24.devtest.domain.model.Product
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class ProductListViewModel @Inject constructor(
    private val getProductList: GetProductList
) : ViewModel() {

    private val _products = MutableLiveData<ProductListData>()
    val products: LiveData<ProductListData>
        get() = _products

    private val _loadError = MutableLiveData(false)
    val loadError: LiveData<Boolean>
        get() = _loadError

    private val _refreshing = MutableLiveData(false)
    val refreshing: LiveData<Boolean>
        get() = _refreshing

    init {
        loadProducts()
    }

    fun loadProducts() {
        viewModelScope.launch {
            try {
                _refreshing.value = true
                _products.value = getProductList.execute(Unit)
                _loadError.value = false
            } catch (ex: Exception) {
                _loadError.value = true //smth goes wrong (:
            } finally {
                _refreshing.value = false
            }
        }
    }
}