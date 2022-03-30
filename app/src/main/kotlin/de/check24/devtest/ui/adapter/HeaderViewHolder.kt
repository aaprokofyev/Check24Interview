package de.check24.devtest.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import de.check24.devtest.databinding.HeaderBinding
import de.check24.devtest.domain.model.ProductListMetadata

class HeaderViewHolder(
    private var binding: HeaderBinding
) : RecyclerView.ViewHolder(binding.root) {

    var productListMetadata: ProductListMetadata? = null

    fun bind(productListMetadata: ProductListMetadata?) {
        this.productListMetadata = productListMetadata
        binding.header = productListMetadata
        binding.executePendingBindings()
    }
}