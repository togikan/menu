package com.thk.feature_item.data.network.response

import com.thk.feature_item.data.network.model.CategoryJson

internal data class GetCategoryListResponse(
    val categoryList: List<CategoryJson>
)
