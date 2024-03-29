package com.thk.feature_product.data.network.service

import com.thk.feature_product.data.network.model.CategoryJson
import retrofit2.http.GET

internal interface ProductRetrofitService {

    @GET(".")
    suspend fun getCategoryListAsync(): List<CategoryJson>?
}