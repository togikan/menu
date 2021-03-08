package com.thk.feature_product.domain.repository

import com.thk.feature_product.domain.model.Category
import com.thk.feature_product.domain.model.Product

internal interface ProductRepository {

    suspend fun getCategoryList(): List<Category>
}