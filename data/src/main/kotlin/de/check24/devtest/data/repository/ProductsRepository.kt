package de.check24.devtest.data.repository

import de.check24.devtest.data.mapper.toProductList
import de.check24.devtest.data.net.ProductAPI
import de.check24.devtest.domain.model.Product
import de.check24.devtest.domain.repository.ProductsRepository
import javax.inject.Inject


class ProductsRepository @Inject constructor(private val api: ProductAPI) :
    ProductsRepository {

    override suspend fun getProductList(): List<Product> {
        return api.getProductList().toProductList()
    }

    override fun clear() {
    }
}