package de.check24.devtest.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.check24.devtest.databinding.FooterBinding
import de.check24.devtest.databinding.HeaderBinding
import de.check24.devtest.databinding.ListItemNonAvailProductBinding
import de.check24.devtest.databinding.ListItemProductBinding
import de.check24.devtest.domain.interactor.ProductListData
import de.check24.devtest.domain.model.ProductListMetadata
import de.check24.devtest.ui.action.ProductActionListener

class ProductListAdapter(
    private val listener: ProductActionListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items: ArrayList<ProductListItem> = ArrayList()
    private var productListMetadata: ProductListMetadata? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when (viewType) {
            PRODUCT_AVAILABLE -> ProductViewHolder(
                ListItemProductBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ), listener
            )
            PRODUCT_NOT_AVAILABLE -> ProductNonAvailViewHolder(
                ListItemNonAvailProductBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ), listener
            )
            FOOTER_VIEW -> FooterViewHolder(
                FooterBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            HEADER_VIEW -> HeaderViewHolder(
                HeaderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException("Invalid type")
        }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        when (holder) {
            is ProductViewHolder -> holder.bind((items[position] as ProductListItem.ProductItem).product)
            is ProductNonAvailViewHolder -> holder.bind((items[position] as ProductListItem.ProductItem).product)
            is FooterViewHolder -> holder.bind()
            is HeaderViewHolder -> holder.bind(productListMetadata = productListMetadata)
            else -> throw IllegalArgumentException("Invalid type")
        }


    override fun getItemViewType(position: Int): Int {
        return when (val item = items[position]) {
            is ProductListItem.HeaderItem -> HEADER_VIEW
            is ProductListItem.FooterItem -> FOOTER_VIEW
            else -> if (item is ProductListItem.ProductItem && item.product.available) PRODUCT_AVAILABLE else PRODUCT_NOT_AVAILABLE
        }
    }


    override fun getItemCount(): Int = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(productListData: ProductListData) {
        this.items.clear()
        this.items.add(ProductListItem.HeaderItem)
        this.items.addAll(productListData.products.map { ProductListItem.ProductItem(it) })
        this.items.add(ProductListItem.FooterItem)
        this.productListMetadata = productListData.productListMeta
        notifyDataSetChanged()
    }

    companion object {
        private const val PRODUCT_AVAILABLE = 0
        private const val PRODUCT_NOT_AVAILABLE = 1
        private const val HEADER_VIEW = 2
        private const val FOOTER_VIEW = 3
    }
}