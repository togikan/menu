package com.thk.feature_product.presentation

import androidx.navigation.fragment.FragmentNavigator
import com.thk.feature_product.data.DataFixtures
import com.thk.feature_product.data.network.model.toDomainModel
import com.thk.feature_product.domain.extensions.formatToDisplay
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
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.amshove.kluent.shouldBeEqualTo
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

    @RelaxedMockK
    internal lateinit var mockNavManager: NavManager

    @MockK
    internal lateinit var mockGetCategoryListUseCase: GetCategoryListUseCase

    @MockK
    internal lateinit var extras: FragmentNavigator.Extras

    private lateinit var cut: ProductListViewModel

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)

        cut = ProductListViewModel(
            mockNavManager,
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
    fun `navigate to album details`() {
        // given
        val product = DataFixtures.getProductDataModel().toDomainModel()

        val navDirections = ProductListFragmentDirections.actionProductListToProductDetail(
            product.name,
            product.url,
            product.salePrice.formatToDisplay()
        )

        // when
        cut.navigateToProductDetails(product, extras)

        // then
        coVerify { mockNavManager.navigate(navDirections, extras) }
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
