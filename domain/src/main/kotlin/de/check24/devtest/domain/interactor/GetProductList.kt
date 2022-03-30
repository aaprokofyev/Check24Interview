package de.check24.devtest.domain.interactor

import de.check24.devtest.domain.model.*
import de.check24.devtest.domain.repository.ProductsRepository
import javax.inject.Inject

class GetProductList @Inject constructor(
    private val productsRepository: ProductsRepository
) : UseCase<Unit, ProductListData>() {
    override suspend fun performAction(param: Unit) =
        productsRepository.getProductList()
}

data class ProductListData(
    val products: List<Product>,
    val productListMeta: ProductListMetadata
)