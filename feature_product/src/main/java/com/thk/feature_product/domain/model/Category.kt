package com.thk.feature_product.domain.model

internal data class Category(
    val id: String,
    val name: String,
    val description: String,
    val products: List<Product>
)