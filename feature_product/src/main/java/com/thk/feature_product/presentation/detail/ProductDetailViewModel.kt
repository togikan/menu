package com.thk.feature_product.presentation.detail

import androidx.lifecycle.viewModelScope
import com.thk.feature_product.domain.model.Product
import com.thk.menu.base.presentation.viewmodel.BaseAction
import com.thk.menu.base.presentation.viewmodel.BaseViewModel
import com.thk.menu.base.presentation.viewmodel.BaseViewState
import com.thk.feature_product.presentation.detail.ProductDetailViewModel.Action
import com.thk.feature_product.presentation.detail.ProductDetailViewModel.Action.ProductLoadingSuccess
import com.thk.feature_product.presentation.detail.ProductDetailViewModel.Action.ProductLoadingFailure
import kotlinx.coroutines.launch

internal class ProductDetailViewModel(
    private val args: ProductDetailFragmentArgs
) : BaseViewModel<ProductDetailViewModel.ViewState, Action>(ViewState()) {

    override fun onReduceState(viewAction: Action) = when (viewAction) {
        is ProductLoadingSuccess -> state.copy(
            isLoading = false,
            isError = false,
            categoryId = viewAction.product.categoryId,
            productId = viewAction.product.id
        )
        is ProductLoadingFailure -> state.copy(
            isLoading = false,
            isError = true,
            categoryId = "",
            productId = ""
        )
    }

    internal data class ViewState(
        val isLoading: Boolean = true,
        val isError: Boolean = false,
        val categoryId: String = "",
        val productId: String = "",
    ) : BaseViewState

    internal sealed class Action : BaseAction {
        class ProductLoadingSuccess(val product: Product) : Action()
        object ProductLoadingFailure : Action()
    }
}