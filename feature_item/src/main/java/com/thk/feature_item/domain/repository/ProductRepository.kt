package com.thk.feature_item.domain.repository

import com.thk.feature_item.domain.model.Category
import com.thk.feature_item.domain.model.Product

internal interface ProductRepository {
    suspend fun getCategoryList(): List<Category>
}