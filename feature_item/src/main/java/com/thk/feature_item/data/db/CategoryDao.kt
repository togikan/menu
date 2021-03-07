package com.thk.feature_item.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.thk.feature_item.data.db.model.CategoryEntity

@Dao
internal interface CategoryDao {

    @Query("SELECT * FROM categories")
    suspend fun getAll(): List<CategoryEntity>

    @Query("SELECT * FROM categories where id = :id")
    suspend fun getCategory(id: String): CategoryEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(categories: List<CategoryEntity>)
}