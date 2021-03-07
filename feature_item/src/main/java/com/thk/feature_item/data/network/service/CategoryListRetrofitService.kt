package com.thk.feature_item.data.network.service

import com.thk.feature_item.data.network.response.GetCategoryListResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

internal interface CategoryListRetrofitService {

    @GET("/")
    suspend fun getCategoryListAsync(): GetCategoryListResponse?
}