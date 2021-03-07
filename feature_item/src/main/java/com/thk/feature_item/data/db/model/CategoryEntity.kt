package com.thk.feature_item.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.thk.feature_item.domain.model.Category

@Entity(tableName = "categories")
@TypeConverters(ProductEntityTypeConverter::class)
internal data class CategoryEntity(
    @PrimaryKey val id: String,
    val name: String,
    val description: String,
    val products: List<ProductEntity> = listOf()
)

internal fun CategoryEntity.toDomainModel() =
    Category(
        this.id,
        this.name,
        this.description,
        this.products.mapNotNull { it.toDomainModel() }
    )

internal class ProductEntityTypeConverter {
    private val type = Types.newParameterizedType(List::class.java, ProductEntity::class.java)
    private val adapter: JsonAdapter<List<ProductEntity>> = Moshi.Builder().build().adapter(type)

    @TypeConverter
    fun stringToList(data: String?) =
            data?.let { adapter.fromJson(it) } ?: listOf()

    @TypeConverter
    fun listToString(someObjects: List<ProductEntity>): String =
            adapter.toJson(someObjects)
}