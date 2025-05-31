package com.plcoding.dictionary.feature_deliverer.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.plcoding.dictionary.core.util.JsonParser
import com.plcoding.dictionary.feature_deliverer.domain.model.Product

@ProvidedTypeConverter
class ProductConverters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromProductsJson(json: String?): List<Product> {
        if (json.isNullOrEmpty()) return emptyList()
        return jsonParser.fromJson<List<Product>>(
            json,
            object : TypeToken<List<Product>>() {}.type
        ) ?: emptyList()
    }


    @TypeConverter
    fun toProductsJson(products: List<Product>?): String {
        if (products == null) return "[]"
        return jsonParser.toJson(
            products,
            object : TypeToken<List<Product>>() {}.type
        ) ?: "[]"
    }
}
