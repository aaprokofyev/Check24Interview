package de.check24.devtest.domain.model

data class ProductListMetadata(
    val title: String,
    val subtitle: String,
    val filters: List<String>
)