package de.check24.devtest.domain.model

data class Product(
    val id: Long,
    val name: String,
    val description: String,
    val price: String,
    val releaseDate: String,
    val available: Boolean,
    val imageUrl: String
)