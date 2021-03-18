package com.thk.feature_product.presentation

import com.thk.feature_product.domain.model.Category
import com.thk.feature_product.domain.usecase.GetCategoryListUseCase
import com.thk.feature_product.presentation.list.ProductListFragmentDirections
import com.thk.feature_product.presentation.list.ProductListViewModel
import com.thk.library_test_extensions.CoroutinesTestExtension
import com.thk.library_test_extensions.InstantTaskExecutorExtension
import com.thk.menu.base.presentation.navigation.NavManager
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.amshove.kluent.shouldBeEqualTo
import org.junit.After
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

class ProductListViewModelTest {

    @ExperimentalCoroutinesApi
    @JvmField
    @RegisterExtension
    val coroutinesTestExtension = CoroutinesTestExtension()

    @JvmField
    @RegisterExtension
    var instantTaskExecutorExtension = InstantTaskExecutorExtension()

    @MockK
    internal lateinit var mockGetCategoryListUseCase: GetCategoryListUseCase

    private lateinit var cut: ProductListViewModel

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)

        cut = ProductListViewModel(
            mockGetCategoryListUseCase
        )
    }

    @Test
    fun `execute getCategoryListUseCase`() {
        // when
        cut.loadData()

        // then
        coVerify { mockGetCategoryListUseCase.execute() }
    }

    @Test
    fun `verify state when GetCategoryListUseCase returns empty list`() {
        // given
        coEvery { mockGetCategoryListUseCase.execute() } returns GetCategoryListUseCase.Result.Success(
            emptyList()
        )

        // when
        cut.loadData()

        // then
        cut.stateLiveData.value shouldBeEqualTo ProductListViewModel.ViewState(
            isLoading = false,
            isError = true,
            categories = listOf()
        )
    }

    @Test
    fun `verify state when GetCategoryListUseCase returns non-empty list`() {
        // given
        val category = Category("id", "name", "description", listOf())
        val categories = listOf(category)
        coEvery { mockGetCategoryListUseCase.execute() } returns GetCategoryListUseCase.Result.Success(
            categories
        )

        // when
        cut.loadData()

        // then
        cut.stateLiveData.value shouldBeEqualTo ProductListViewModel.ViewState(
            isLoading = false,
            isError = false,
            categories = categories
        )
    }
}