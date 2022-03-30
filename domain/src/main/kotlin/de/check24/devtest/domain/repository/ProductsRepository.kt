package de.check24.devtest.domain.repository

import de.check24.devtest.domain.model.Product

interface ProductsRepository : Repository {
    suspend fun getProductList(): List<Product>
}