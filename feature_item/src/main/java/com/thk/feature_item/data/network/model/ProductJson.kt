package com.thk.feature_item.data.network.model

import com.squareup.moshi.Json
import com.thk.feature_item.data.db.model.ProductEntity
import com.thk.feature_item.domain.model.Product

internal data class ProductJson(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "categoryId") val categoryId: String,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "url") val url: String,
    @field:Json(name = "description") val description: String,
    @field:Json(name = "salePrice") val salePrice: SalePriceJson
)

internal fun ProductJson.toEntity() =
    ProductEntity(
        id = this.id,
        categoryId = this.categoryId,
        name = this.name,
        url = this.url,
        description = this.description,
        salePrice = this.salePrice.toEntity()
    )

internal fun ProductJson.toDomainModel(): Product {
    return Product(
        id = this.id,
        categoryId = this.categoryId,
        name = this.name,
        url = this.url,
        description = this.description,
        salePrice = this.salePrice.toDomainModel()
    )
}