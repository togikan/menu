package com.thk.feature_item.presentation

import androidx.fragment.app.Fragment
import com.thk.feature_item.MODULE_NAME
import com.thk.feature_item.presentation.list.ItemRecyclerViewAdapter
import com.thk.feature_item.presentation.list.ProductListViewModel
import com.thk.menu.base.di.KotlinViewModelProvider
import org.kodein.di.Kodein
import org.kodein.di.android.x.AndroidLifecycleScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton

internal val presentationModule = Kodein.Module("${MODULE_NAME}PresentationModule") {

    bind<ProductListViewModel>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        KotlinViewModelProvider.of(context) { ProductListViewModel(instance(), instance()) }
    }

    bind() from singleton { ItemRecyclerViewAdapter() }
}