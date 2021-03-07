package com.thk.feature_product.data

import com.thk.feature_product.data.db.CategoryDao
import com.thk.feature_product.data.db.model.toDomainModel
import com.thk.feature_product.data.network.model.toDomainModel
import com.thk.feature_product.data.network.service.CategoryListRetrofitService
import com.thk.feature_product.domain.model.Category
import com.thk.feature_product.domain.repository.ProductRepository
import java.net.UnknownHostException

internal class ProductRepositoryImpl(
    private val categoryListRetrofitService: CategoryListRetrofitService,
    private val categoryDao: CategoryDao
) : ProductRepository {

    override suspend fun getCategoryList(): List<Category> {
        return try {
            categoryListRetrofitService.getCategoryListAsync()
                ?.mapNotNull {
                    it.toDomainModel()
                } ?: listOf()
        } catch (e: UnknownHostException) {
            categoryDao.getAll().mapNotNull {
                it.toDomainModel()
            } ?: listOf()
        }
    }
}