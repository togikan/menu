package com.thk.feature_product.data.network

import com.thk.feature_product.data.network.model.SalePriceJson

internal fun SalePriceJson.formatToDisplay() : String {
    return "$currency $amount"
}