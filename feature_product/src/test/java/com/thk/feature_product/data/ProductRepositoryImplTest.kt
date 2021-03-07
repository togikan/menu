package com.thk.feature_product.data

import com.thk.feature_product.data.db.ProductDao
import com.thk.feature_product.data.network.model.toDomainModel
import com.thk.feature_product.data.network.service.ProductRetrofitService
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ProductRepositoryImplTest {

    @MockK
    internal lateinit var mockService: ProductRetrofitService

    @MockK
    internal lateinit var mockProductDao: ProductDao

    private lateinit var productRepositoryImp: ProductRepositoryImpl

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)

        productRepositoryImp = ProductRepositoryImpl(mockService, mockProductDao)
    }

    @Test
    fun `getCategoryList fetches Category list and maps to model`() {
        // given
        coEvery {
            mockService.getCategoryListAsync()
        } returns listOf(DataFixtures.getCategory())

        // when
        val result = runBlocking { productRepositoryImp.getCategoryList() }

        // then
        result shouldBeEqualTo DataFixtures.getCategories().map { it.toDomainModel() }
    }
}