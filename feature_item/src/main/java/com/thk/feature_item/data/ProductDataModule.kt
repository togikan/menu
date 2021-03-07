package com.thk.feature_item.data

import androidx.room.Room
import androidx.room.RoomDatabase
import com.thk.feature_item.MODULE_NAME
import com.thk.feature_item.data.db.CategoryDao
import com.thk.feature_item.data.db.CategoryDatabase
import com.thk.feature_item.data.network.service.CategoryListRetrofitService
import com.thk.feature_item.domain.repository.ProductRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit

internal val dataModule = Kodein.Module("${MODULE_NAME}DataModule") {

    bind<ProductRepository>() with singleton { ProductRepositoryImpl(instance(), instance()) }

    bind() from singleton { instance<Retrofit>().create(CategoryListRetrofitService::class.java) }

    bind<RoomDatabase.Builder<CategoryDatabase>>() with singleton {
        Room.databaseBuilder(
            instance(),
            CategoryDatabase::class.java,
            "Category.db"
        )
    }

    bind<CategoryDatabase>() with singleton { instance<RoomDatabase.Builder<CategoryDatabase>>().build() }

    bind<CategoryDao>() with singleton { instance<CategoryDatabase>().categories() }
}
