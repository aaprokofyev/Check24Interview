package de.check24.devtest.ui.adapter

import de.check24.devtest.domain.model.Product

sealed class ProductListItem {
    object HeaderItem : ProductListItem()

    object FooterItem : ProductListItem()
    class ProductItem(
        val product: Product
    ) : ProductListItem()
}
