package de.check24.devtest.data.net.model

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("header")
    val header: HeaderData,
    @SerializedName("filters")
    val filters: List<String>,
    @SerializedName("products")
    val products: List<ProductData>
)

data class ProductData(
    @SerializedName("name")
    val name: String,
    @SerializedName("id")
    val id: Long,
    @SerializedName("description")
    val description: String,
    @SerializedName("price")
    val price: PriceData,
    @SerializedName("releaseDate")
    val releaseDate: Long,
    @SerializedName("available")
    val available: Boolean,
    @SerializedName("imageURL")
    val imageUrl: String,
    @SerializedName("longDescription")
    val longDescription: String,
    @SerializedName("rating")
    val rating: Float,
)

data class PriceData(
    @SerializedName("value")
    val value: String,
    @SerializedName("currency")
    val currency: String
)

data class HeaderData(
    @SerializedName("headerTitle")
    val headerTitle: String,
    @SerializedName("headerDescription")
    val headerDescription: String
)