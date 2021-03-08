package com.thk.feature_product.data.network.model

import com.squareup.moshi.Json
import com.thk.feature_product.data.db.model.ProductEntity
import com.thk.feature_product.domain.model.Product
import com.thk.menu.BuildConfig

internal data class ProductJson(
        @field:Json(name = "id") val id: String,
        @field:Json(name = "categoryId") val categoryId: String,
        @field:Json(name = "name") val name: String,
        @field:Json(name = "url") val url: String?,
        @field:Json(name = "description") val description: String,
        @field:Json(name = "salePrice") val salePrice: SalePriceJson
)

internal fun ProductJson.toEntity() =
        ProductEntity(
                id = this.id,
                categoryId = this.categoryId,
                name = this.name,
                url = "${BuildConfig.API_BASE_URL}${this.url}",
                description = this.description,
                salePrice = "${this.salePrice.currency} ${this.salePrice.amount}"
        )

internal fun ProductJson.toDomainModel(): Product {
    return Product(
            id = this.id,
            categoryId = this.categoryId,
            name = this.name,
            url = "${BuildConfig.API_BASE_URL}${this.url}",
            description = this.description,
            salePrice = "${this.salePrice.currency} ${this.salePrice.amount}"
    )
}