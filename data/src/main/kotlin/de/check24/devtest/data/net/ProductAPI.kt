package de.check24.devtest.data.net

import de.check24.devtest.data.net.model.ProductResponse
import retrofit2.http.GET

interface ProductAPI {
    @GET("/products-test.json")
    suspend fun getProductList(): ProductResponse
}