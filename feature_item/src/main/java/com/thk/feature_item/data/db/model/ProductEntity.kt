package com.thk.feature_item.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.thk.feature_item.domain.model.Product

internal data class ProductEntity(
    @PrimaryKey val id: String,
    val categoryId: String,
    val name: String,
    val url: String,
    val description: String,
    val salePrice: SalePriceEntity
)

internal fun ProductEntity.toDomainModel() =
    Product(
        this.id,
        this.categoryId,
        this.name,
        this.url,
        this.description,
        this.salePrice.toDomainModel()
    )