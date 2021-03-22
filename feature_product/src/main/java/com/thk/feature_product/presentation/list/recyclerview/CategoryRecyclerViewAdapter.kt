package com.thk.feature_product.presentation.list.recyclerview

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.thk.feature_product.R
import com.thk.feature_product.databinding.FragmentCategoryItemBinding
import com.thk.feature_product.domain.model.Category
import com.thk.feature_product.domain.model.Product
import com.thk.menu.base.delegate.observer

internal class CategoryRecyclerViewAdapter :
    RecyclerView.Adapter<CategoryRecyclerViewAdapter.ViewHolder>() {

    var categories: List<Category> by observer(listOf()) {
        notifyDataSetChanged()
    }

    private var onDebouncedClickListener: ((product: Product, view: View) -> Unit)? = null

    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FragmentCategoryItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int = categories.size

    fun setOnDebouncedClickListener(listener: (product: Product, view: View) -> Unit) {
        this.onDebouncedClickListener = listener
    }

    internal inner class ViewHolder(private val binding: FragmentCategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(category: Category) {
            binding.name.text = category.name

            binding.recyclerViewProduct.apply {
                val columnWidth = context.resources.getDimension(R.dimen.column_size).toInt()
                layoutManager = GridAutoFitLayoutManager(context, columnWidth)
                val productAdapter = ProductRecyclerViewAdapter(category.products)
                onDebouncedClickListener?.let { productAdapter.setOnDebouncedClickListener(it) }
                adapter = productAdapter
                setRecycledViewPool(viewPool)
            }
        }
    }
}