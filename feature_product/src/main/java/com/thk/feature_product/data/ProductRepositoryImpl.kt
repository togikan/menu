package com.thk.feature_product.data

import com.thk.feature_product.data.db.ProductDao
import com.thk.feature_product.data.db.model.toDomainModel
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
        try {
            val list = productRetrofitService.getCategoryListAsync()

            val entityList = list?.mapNotNull {
                it.toEntity()
            } ?: listOf()
            productDao.insertCategory(entityList)

            return list?.mapNotNull {
                it.toDomainModel()
            } ?: listOf()
        } catch (e: UnknownHostException) {
            return productDao.getAll().mapNotNull {
                it.toDomainModel()
            }
        }
    }
}