package com.thk.feature_product.domain.extensions

import com.thk.feature_product.domain.model.SalePrice

internal fun SalePrice.formatToDisplay(): String {
    return "$currency $amount"
}
