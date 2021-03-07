package com.thk.feature_item.data.db.model

import com.thk.feature_item.domain.model.SalePrice

internal data class SalePriceEntity(
    val amount: String,
    val currency: String
)

internal fun SalePriceEntity.toDomainModel() =
    SalePrice(
        this.amount,
        this.currency
    )