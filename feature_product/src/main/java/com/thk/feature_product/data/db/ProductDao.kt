package com.thk.feature_product.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.thk.feature_product.data.db.model.CategoryEntity

@Dao
internal interface ProductDao {

    @Query("SELECT * FROM categories")
    suspend fun getAll(): List<CategoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(categories: List<CategoryEntity>)
}