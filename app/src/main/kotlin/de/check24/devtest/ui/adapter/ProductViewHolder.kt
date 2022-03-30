package de.check24.devtest.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import de.check24.devtest.databinding.ListItemProductBinding
import de.check24.devtest.domain.model.Product
import de.check24.devtest.ui.action.ProductActionListener

class ProductViewHolder(
    private var binding: ListItemProductBinding,
    private val listener: ProductActionListener
) : RecyclerView.ViewHolder(binding.root) {

    var product: Product? = null

    init {
        binding.root.setOnClickListener {
            product?.let { listener.viewProductDetails(product = it) }
        }
    }

    fun bind(product: Product?) {
        this.product = product
        binding.product = product
        binding.executePendingBindings()
    }
}