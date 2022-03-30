package de.check24.devtest.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: Long,
    val name: String,
    val description: String,
    val price: String,
    val releaseDate: String,
    val available: Boolean,
    val imageUrl: String,
    val longDescription: String,
    val rating: Float,
) : Parcelable