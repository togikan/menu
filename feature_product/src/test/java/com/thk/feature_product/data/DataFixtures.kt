package com.thk.feature_product.data

import com.thk.feature_product.data.network.model.CategoryJson
import com.thk.feature_product.data.network.model.ProductJson
import com.thk.feature_product.data.network.model.SalePriceJson
import com.thk.feature_product.data.network.model.toDomainModel

object DataFixtures {

    internal fun getCategory(
        id: String = "id",
        name: String = "name",
        description: String = "description",
        products: List<ProductJson>? = listOf(getProduct())
    ): CategoryJson = CategoryJson(id, name, description, products)

    internal fun getCategories() = listOf(
        getCategory(id = "id", name = "name", description = "description", products = getProducts())
    )

    internal fun getProduct(
        id: String = "id",
        categoryId: String = "categoryId",
        name: String = "name",
        url: String? = "/url",
        description: String = "description",
        salePrice: SalePriceJson = getProductSalePriceDataModel()
    ): ProductJson = ProductJson(id, categoryId, name, url, description, salePrice)

    internal fun getProducts() = listOf(
        getProduct(
            id = "id",
            categoryId = "categoryId",
            name = "name",
            url = "/url",
            description = "description",
            salePrice = getProductSalePriceDataModel()
        )
    )

    internal fun getProductSalePriceDataModel(
        amount: String = "amount",
        currency: String = "currency"
    ) = SalePriceJson(amount, currency)
}