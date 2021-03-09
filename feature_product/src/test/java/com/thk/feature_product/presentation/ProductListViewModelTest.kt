package com.thk.feature_product.presentation

import com.thk.feature_product.domain.model.Category
import com.thk.feature_product.domain.usecase.GetCategoryListUseCase
import com.thk.feature_product.presentation.list.ProductListViewModel
import com.thk.menu.base.presentation.navigation.NavManager
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.amshove.kluent.shouldBeEqualTo
import org.junit.After
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ProductListViewModelTest {

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @MockK
    internal lateinit var mockGetCategoryListUseCase: GetCategoryListUseCase

    @MockK(relaxed = true)
    internal lateinit var mockNavManager: NavManager

    private lateinit var cut: ProductListViewModel

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(mainThreadSurrogate)

        cut = ProductListViewModel(
            mockNavManager,
            mockGetCategoryListUseCase
        )
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

    @Test
    fun `execute getCategoryListUseCase`() {
        // when
        cut.loadData()

        // then
        coVerify { mockGetCategoryListUseCase.execute() }
    }

    @Test
    fun `verify state when GetCategoryListUseCase returns empty list`() = runBlocking {
        launch(Dispatchers.Main) {
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
    }

    @Test
    fun `verify state when GetCategoryListUseCase returns non-empty list`() = runBlocking {
        launch(Dispatchers.Main) {
            // given
            val category = Category("id", "name", "description", listOf())
            val categories = listOf(category)
            coEvery { mockGetCategoryListUseCase.execute() } returns GetCategoryListUseCase.Result.Success(categories)

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
}