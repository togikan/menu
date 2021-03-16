package com.thk.feature_product.presentation.list.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.thk.feature_product.R
import com.thk.feature_product.databinding.FragmentProductItemBinding
import com.thk.feature_product.domain.model.Product
import com.thk.menu.base.delegate.observer
import com.thk.menu.base.presentation.extension.gone
import com.thk.menu.base.presentation.extension.loadFromUrl
import com.thk.menu.base.presentation.extension.setOnDebouncedClickListener
import com.thk.menu.base.presentation.extension.visible

internal class ProductRecyclerViewAdapter(private val products: List<Product>) :
    RecyclerView.Adapter<ProductRecyclerViewAdapter.ViewHolder>() {

    private var onDebouncedClickListener: ((product: Product, view: View) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductRecyclerViewAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FragmentProductItemBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductRecyclerViewAdapter.ViewHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount(): Int = products.size

    fun setOnDebouncedClickListener(listener: (product: Product, view: View) -> Unit) {
        this.onDebouncedClickListener = listener
    }

    internal inner class ViewHolder(private val binding: FragmentProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            binding.name.text = product.name
            binding.image.loadFromUrl(product.url, true)
            binding.root.transitionName = product.name
            itemView.setOnDebouncedClickListener { onDebouncedClickListener?.invoke(product, binding.root) }
        }
    }
}