package de.check24.devtest.data.net.model

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,

    //TODO: Still dummy
)