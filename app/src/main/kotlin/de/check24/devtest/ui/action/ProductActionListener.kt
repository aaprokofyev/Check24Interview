package de.check24.devtest.ui.action

import de.check24.devtest.domain.model.Product

interface ProductActionListener {
    fun viewProductDetails(product: Product)
}