package de.check24.devtest.data.mapper

import de.check24.devtest.data.net.model.ProductResponse
import de.check24.devtest.domain.model.Product

fun ProductResponse.toProductList() =
    listOf(
        Product(
            id = id,
            name = name
        )
    )