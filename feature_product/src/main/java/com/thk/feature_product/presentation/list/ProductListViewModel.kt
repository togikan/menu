package com.thk.feature_product.presentation.list

import androidx.lifecycle.viewModelScope
import com.thk.feature_product.domain.model.Category
import com.thk.feature_product.domain.model.Product
import com.thk.feature_product.domain.usecase.GetCategoryListUseCase
import com.thk.menu.base.presentation.navigation.NavManager
import com.thk.menu.base.presentation.viewmodel.BaseAction
import com.thk.menu.base.presentation.viewmodel.BaseViewModel
import com.thk.menu.base.presentation.viewmodel.BaseViewState
import kotlinx.coroutines.launch

internal class ProductListViewModel(
        private val navManager: NavManager,
        private val getCategoryListUseCase: GetCategoryListUseCase
) : BaseViewModel<ProductListViewModel.ViewState, ProductListViewModel.Action>(ViewState()) {

    override fun onLoadData() {
        getCategoryList()
    }

    override fun onReduceState(viewAction: Action) = when (viewAction) {
        is Action.CategoryListLoadingSuccess -> state.copy(
                isLoading = false,
                isError = false,
                categories = viewAction.categories
        )
        is Action.CategoryListLoadingFailure -> state.copy(
                isLoading = false,
                isError = true,
                categories = listOf()
        )
    }

    private fun getCategoryList() {
        viewModelScope.launch {
            getCategoryListUseCase.execute().also { result ->
                val action = when (result) {
                    is GetCategoryListUseCase.Result.Success ->
                        if (result.data.isEmpty()) {
                            Action.CategoryListLoadingFailure
                        } else {
                            Action.CategoryListLoadingSuccess(result.data)
                        }

                    is GetCategoryListUseCase.Result.Error ->
                        Action.CategoryListLoadingFailure
                }
                sendAction(action)
            }
        }
    }

    fun navigateToProductDetails(product: Product) {
        val navDirections = ProductListFragmentDirections.actionProductListToProductDetail(
                name = product.name,
                url = product.url,
                salePrice = product.salePrice
        )
        navManager.navigate(navDirections)
    }

    internal data class ViewState(
            val isLoading: Boolean = true,
            val isError: Boolean = false,
            val categories: List<Category> = listOf()
    ) : BaseViewState

    internal sealed class Action : BaseAction {
        class CategoryListLoadingSuccess(val categories: List<Category>) : Action()
        object CategoryListLoadingFailure : Action()
    }
}