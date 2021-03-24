package com.thk.feature_product.domain

import com.thk.feature_product.domain.model.Category
import com.thk.feature_product.domain.model.Product
import com.thk.feature_product.domain.model.SalePrice

object DomainFixtures {

    internal fun getCategory(
        id: String = "id",
        name: String = "name",
        description: String = "description",
        products: List<Product> = listOf(getProduct())
    ): Category = Category(id, name, description, products)

    internal fun getProduct(
        id: String = "id",
        categoryId: String = "categoryId",
        name: String = "name",
        url: String? = "url",
        description: String = "description",
        salePrice: SalePrice = getSalePrice()
    ): Product = Product(id, categoryId, name, url, description, salePrice)

    internal fun getSalePrice(
        amount: String = "amount",
        currency: String = "currency",
    ): SalePrice = SalePrice(amount, currency)
}
