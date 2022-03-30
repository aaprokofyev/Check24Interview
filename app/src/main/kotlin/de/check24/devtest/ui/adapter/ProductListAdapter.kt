package de.check24.devtest.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.check24.devtest.databinding.ListItemProductBinding
import de.check24.devtest.domain.model.Product
import de.check24.devtest.ui.action.ProductActionListener

class ProductListAdapter(
    private val listener: ProductActionListener
): RecyclerView.Adapter<ProductViewHolder>() {

    private val items: ArrayList<Product> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ProductViewHolder(
            ListItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), listener
        )

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) =
        holder.bind(items[position])

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
}