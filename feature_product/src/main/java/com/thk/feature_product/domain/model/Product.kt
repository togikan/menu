package com.thk.feature_product.domain.model

internal data class Product(
    val id: String,
    val categoryId: String,
    val name: String,
    val url: String?,
    val description: String,
    val salePrice: SalePrice
)
