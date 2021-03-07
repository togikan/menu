package com.thk.feature_product.data.network.service

import com.thk.feature_product.data.network.response.GetCategoryListResponse
import retrofit2.http.GET

internal interface CategoryListRetrofitService {

    @GET("/")
    suspend fun getCategoryListAsync(): GetCategoryListResponse?
}