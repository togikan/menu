package com.thk.feature_item.data

import com.thk.feature_item.data.db.CategoryDao
import com.thk.feature_item.data.db.model.toDomainModel
import com.thk.feature_item.data.network.model.toDomainModel
import com.thk.feature_item.data.network.service.CategoryListRetrofitService
import com.thk.feature_item.domain.model.Category
import com.thk.feature_item.domain.repository.ProductRepository
import java.net.UnknownHostException

internal class ProductRepositoryImpl(
    private val categoryListRetrofitService: CategoryListRetrofitService,
    private val categoryDao: CategoryDao
) : ProductRepository {

    override suspend fun getCategoryList(): List<Category> {
        return try {
            categoryListRetrofitService.getCategoryListAsync()
                ?.categoryList?.mapNotNull { it.toDomainModel() } ?: listOf()
        } catch (e: UnknownHostException) {
            categoryDao.getAll().mapNotNull { it.toDomainModel() } ?: listOf()
        }
    }
}