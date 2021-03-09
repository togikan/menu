package com.thk.feature_product.domain.usecase

import com.thk.feature_product.data.ProductRepositoryImpl
import com.thk.feature_product.domain.DomainFixtures
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GetCategoryListUseCaseTest {

    @MockK
    internal lateinit var mockProductRepository: ProductRepositoryImpl

    private lateinit var cut: GetCategoryListUseCase

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)

        cut = GetCategoryListUseCase(mockProductRepository)
    }

    @Test
    fun `return list of categories`() {
        // given
        val categories = listOf(DomainFixtures.getCategory(), DomainFixtures.getCategory())
        coEvery { mockProductRepository.getCategoryList() } returns categories

        // when
        val result = runBlocking { cut.execute() }

        // then
        result shouldBeEqualTo GetCategoryListUseCase.Result.Success(categories)
    }
}