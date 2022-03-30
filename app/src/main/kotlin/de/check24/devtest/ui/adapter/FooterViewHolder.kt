package de.check24.devtest.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import de.check24.devtest.databinding.FooterBinding

class FooterViewHolder(
    private var binding: FooterBinding
) : RecyclerView.ViewHolder(binding.root) {

    //TODO Add click listener and notify back to fragment to open webpage
    fun bind() {
        binding.executePendingBindings()
    }
}