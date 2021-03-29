package com.thk.feature_product.data

import com.thk.feature_product.data.db.ProductDao
import com.thk.feature_product.data.db.model.toDomainModel
import com.thk.feature_product.data.network.model.CategoryJson
import com.thk.feature_product.data.network.model.toDomainModel
import com.thk.feature_product.data.network.model.toEntity
import com.thk.feature_product.data.network.service.ProductRetrofitService
import com.thk.feature_product.domain.model.Category
import com.thk.feature_product.domain.repository.ProductRepository
import java.net.UnknownHostException

internal class ProductRepositoryImpl(
    private val productRetrofitService: ProductRetrofitService,
    private val productDao: ProductDao
) : ProductRepository {

    override suspend fun getCategoryList(): List<Category> {
        return try {
            val list = productRetrofitService.getCategoryListAsync()
            insertListToDatabase(list)
            getListFromResponse(list)
        } catch (e: UnknownHostException) {
            getListFromDatabase()
        }
    }

    private suspend fun insertListToDatabase(list: List<CategoryJson>?) {
        val entityList = list?.mapNotNull {
            it.toEntity()
        } ?: listOf()
        productDao.insertCategory(entityList)
    }

    private fun getListFromResponse(list: List<CategoryJson>?): List<Category> {
        return list?.mapNotNull {
            it.toDomainModel()
        } ?: listOf()
    }

    private suspend fun getListFromDatabase(): List<Category> {
        return productDao.getAll().mapNotNull {
            it.toDomainModel()
        }
    }
}
