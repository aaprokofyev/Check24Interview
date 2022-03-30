package de.check24.devtest.ui.productdetails

import androidx.lifecycle.*
import javax.inject.Inject

class ProductDetailsViewModel @Inject constructor() : ViewModel() {

    private val _loadError = MutableLiveData(false)
    val loadError: LiveData<Boolean>
        get() = _loadError

}