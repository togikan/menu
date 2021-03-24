package com.thk.feature_product.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.thk.feature_product.data.db.model.CategoryEntity

@Database(entities = [CategoryEntity::class], version = 1, exportSchema = false)
internal abstract class ProductDatabase : RoomDatabase() {
    abstract fun categories(): ProductDao
}
