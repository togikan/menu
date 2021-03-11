package com.thk.feature_product.data.network

import com.thk.feature_product.data.network.model.SalePriceJson
import com.thk.feature_product.data.network.model.toEntity

fun SalePriceJson.formatToDisplay() : String {
    return "$currency $amount"
}