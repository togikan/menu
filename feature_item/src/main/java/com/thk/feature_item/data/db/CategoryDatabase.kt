package com.thk.feature_item.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.thk.feature_item.data.db.model.CategoryEntity

@Database(entities = [CategoryEntity::class], version = 1, exportSchema = false)
internal abstract class CategoryDatabase : RoomDatabase() {
    abstract fun categories(): CategoryDao
}