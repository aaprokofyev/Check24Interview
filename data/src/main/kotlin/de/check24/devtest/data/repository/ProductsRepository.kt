package de.check24.devtest.data.repository

import de.check24.devtest.data.mapper.toProductList
import de.check24.devtest.data.mapper.toProductListMeta
import de.check24.devtest.data.net.ProductAPI
import de.check24.devtest.domain.interactor.ProductListData
import de.check24.devtest.domain.repository.ProductsRepository
import javax.inject.Inject


class ProductsRepository @Inject constructor(private val api: ProductAPI) :
    ProductsRepository {

    override suspend fun getProductList(): ProductListData {
        val productResponse = api.getProductList()
        return ProductListData(
            products = productResponse.toProductList(),
            productListMeta =productResponse.toProductListMeta()
        )
    }

    override fun clear() {
    }
}