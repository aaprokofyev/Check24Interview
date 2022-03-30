package de.check24.devtest.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.check24.devtest.databinding.ListItemNonAvailProductBinding
import de.check24.devtest.databinding.ListItemProductBinding
import de.check24.devtest.domain.model.Product
import de.check24.devtest.ui.action.ProductActionListener

class ProductListAdapter(
    private val listener: ProductActionListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items: ArrayList<Product> = ArrayList()

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
            else -> throw IllegalArgumentException("Invalid type")
        }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        when (holder) {
            is ProductViewHolder -> holder.bind(items[position])
            is ProductNonAvailViewHolder -> holder.bind(items[position])
            else -> throw IllegalArgumentException("Invalid type")
        }


    override fun getItemViewType(position: Int) =
        if (items[position].available) PRODUCT_AVAILABLE else PRODUCT_NOT_AVAILABLE


    override fun getItemCount(): Int = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(items: List<Product>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun onItemChanged(position: Int) {
        notifyItemChanged(position)
    }

    companion object {
        private const val PRODUCT_AVAILABLE = 0
        private const val PRODUCT_NOT_AVAILABLE = 1
    }
}