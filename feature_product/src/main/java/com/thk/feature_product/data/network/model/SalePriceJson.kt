package com.thk.feature_product.data.network.model

import com.squareup.moshi.Json
import com.thk.feature_product.data.db.model.SalePriceEntity
import com.thk.feature_product.domain.model.SalePrice

internal data class SalePriceJson(
    @field:Json(name = "amount") val amount: String,
    @field:Json(name = "currency") val currency: String
)

internal fun SalePriceJson.toEntity() =
    SalePriceEntity(
        amount = this.amount,
        currency = this.currency
    )

internal fun SalePriceJson.toDomainModel() =
    SalePrice(
        amount = this.amount,
        currency = this.currency
    )