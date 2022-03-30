package de.check24.devtest.domain.repository

import de.check24.devtest.domain.interactor.ProductListData

interface ProductsRepository : Repository {
    suspend fun getProductList(): ProductListData
}