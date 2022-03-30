package de.check24.devtest.ui.productlist

import androidx.lifecycle.*
import javax.inject.Inject

class ProductListViewModel @Inject constructor() : ViewModel() {

    private val _loadError = MutableLiveData(false)
    val loadError: LiveData<Boolean>
        get() = _loadError
}