package com.thk.feature_product.domain.usecase

import com.thk.feature_product.domain.model.Category
import com.thk.feature_product.domain.repository.ProductRepository
import java.io.IOException

internal class GetCategoryListUseCase(
    private val productRepository: ProductRepository
) {
    sealed class Result {
        data class Success(val data: List<Category>) : Result()
        data class Error(val e: Throwable) : Result()
    }

    suspend fun execute(): Result {
        return try {
            Result.Success(
                productRepository.getCategoryList())
        } catch (e: IOException) {
            Result.Error(e)
        }
    }
}