package com.thk.feature_product.data

import androidx.room.Room
import androidx.room.RoomDatabase
import com.thk.feature_product.MODULE_NAME
import com.thk.feature_product.data.db.ProductDao
import com.thk.feature_product.data.db.ProductDatabase
import com.thk.feature_product.data.network.service.ProductRetrofitService
import com.thk.feature_product.domain.repository.ProductRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit

internal val dataModule = Kodein.Module("${MODULE_NAME}DataModule") {

    bind<ProductRepository>() with singleton { ProductRepositoryImpl(instance(), instance()) }

    bind() from singleton { instance<Retrofit>().create(ProductRetrofitService::class.java) }

    bind<RoomDatabase.Builder<ProductDatabase>>() with singleton {
        Room.databaseBuilder(
            instance(),
            ProductDatabase::class.java,
            "Category.db"
        )
    }

    bind<ProductDatabase>() with singleton { instance<RoomDatabase.Builder<ProductDatabase>>().build() }

    bind<ProductDao>() with singleton { instance<ProductDatabase>().categories() }
}
