package com.thk.feature_product.domain

import com.thk.feature_product.MODULE_NAME
import com.thk.feature_product.domain.usecase.GetCategoryListUseCase
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

internal val domainModule = Kodein.Module("${MODULE_NAME}DomainModule") {

    bind() from singleton { GetCategoryListUseCase(instance()) }
}
