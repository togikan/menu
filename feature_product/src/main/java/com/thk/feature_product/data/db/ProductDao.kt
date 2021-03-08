package com.thk.feature_product.data.db

import androidx.room.*
import com.thk.feature_product.data.db.model.CategoryEntity
import com.thk.feature_product.data.db.model.ProductEntity

@Dao
internal interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(categories: List<CategoryEntity>)

    @Query("SELECT * FROM categories")
    suspend fun getAll(): List<CategoryEntity>
}

