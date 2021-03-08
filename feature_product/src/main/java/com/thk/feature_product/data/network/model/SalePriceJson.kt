package com.thk.feature_product.data.network.model

import com.squareup.moshi.Json

data class SalePriceJson(
    @field:Json(name = "amount") val amount: String,
    @field:Json(name = "currency") val currency: String
)