package de.check24.devtest.data.mapper

import de.check24.devtest.data.net.model.ProductData
import de.check24.devtest.data.net.model.ProductResponse
import de.check24.devtest.domain.model.Product
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.round

fun ProductResponse.toProductList(): List<Product> = products.map { it.toProduct() }

fun ProductData.toProduct() =
    Product(
        id = id,
        name = name,
        description = description,
        price = price.value + " " + price.currency, //Simplified, better to format this on presentation layer
        releaseDate = dateFormatter.format(Date(releaseDate * 1000L)), //Simplified, better to format this on presentation layer
        available = available,
        imageUrl = imageUrl,
        longDescription = longDescription,
        rating = rating,
    )

val dateFormatter = SimpleDateFormat("dd.MM.yyyy", Locale.GERMANY)