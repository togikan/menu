package com.thk.feature_product.data

import com.thk.feature_product.data.network.model.CategoryJson
import com.thk.feature_product.data.network.model.ProductJson
import com.thk.feature_product.data.network.model.SalePriceJson
import com.thk.feature_product.domain.model.Product
import com.thk.feature_product.domain.model.SalePrice

object DataFixtures {

    internal fun getCategoryDataModel(
        id: String = "id",
        name: String = "name",
        description: String = "description",
        products: List<ProductJson>? = listOf(getProductDataModel())
    ): CategoryJson = CategoryJson(id, name, description, products)

    internal fun getCategoriesDataModel() = listOf(
        getCategoryDataModel(
            id = "id",
            name = "name",
            description = "description",
            products = getProductsDataModel()
        )
    )

    internal fun getProductDataModel(
        id: String = "id",
        categoryId: String = "categoryId",
        name: String = "name",
        url: String? = "/url",
        description: String = "description",
        salePrice: SalePriceJson = getSalePriceDataModel()
    ): ProductJson = ProductJson(id, categoryId, name, url, description, salePrice)

    internal fun getProductsDataModel() = listOf(
        getProductDataModel(
            id = "id",
            categoryId = "categoryId",
            name = "name",
            url = "/url",
            description = "description",
            salePrice = getSalePriceDataModel()
        )
    )

    internal fun getSalePriceDataModel(
        amount: String = "amount",
        currency: String = "currency"
    ) = SalePriceJson(amount, currency)
}