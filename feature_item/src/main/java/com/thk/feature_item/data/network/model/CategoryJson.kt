package com.thk.feature_item.data.network.model

import com.squareup.moshi.Json
import com.thk.feature_item.data.db.model.CategoryEntity
import com.thk.feature_item.data.db.model.ProductEntity
import com.thk.feature_item.domain.model.Category
import com.thk.feature_item.domain.model.Product

internal data class CategoryJson(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "description") val description: String,
    @field:Json(name = "products") val products: List<ProductJson>
)

internal fun CategoryJson.toEntity() =
    CategoryEntity(
        id = this.id,
        name = this.name,
        description = this.description,
        products = this.products?.mapNotNull { it.toEntity() } ?: listOf()
    )

internal fun CategoryJson.toDomainModel(): Category {
    return Category(
        id = this.id,
        name = this.name,
        description = this.description,
        products = this.products.mapNotNull { it.toDomainModel() } ?: listOf()
    )
}