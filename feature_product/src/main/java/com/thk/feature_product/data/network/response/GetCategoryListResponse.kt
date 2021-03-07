package com.thk.feature_product.data.network.response

import com.thk.feature_product.data.network.model.CategoryJson

internal data class GetCategoryListResponse(
    val categoryList: List<CategoryJson>
)
