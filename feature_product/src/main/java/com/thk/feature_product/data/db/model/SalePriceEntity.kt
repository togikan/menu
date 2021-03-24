package com.thk.feature_product.data.db.model

import com.thk.feature_product.domain.model.SalePrice

internal data class SalePriceEntity(
    val amount: String,
    val currency: String
)

internal fun SalePriceEntity.toDomainModel() =
    SalePrice(
        amount = this.amount,
        currency = this.currency
    )
