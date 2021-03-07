package com.thk.feature_product.data

import com.thk.feature_product.data.db.ProductDao
import com.thk.feature_product.data.db.model.toDomainModel
import com.thk.feature_product.data.network.model.toDomainModel
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
            productRetrofitService.getCategoryListAsync()
                ?.mapNotNull {
                    it.toDomainModel()
                } ?: listOf()
        } catch (e: UnknownHostException) {
            productDao.getAll().mapNotNull {
                it.toDomainModel()
            } ?: listOf()
        }
    }
}