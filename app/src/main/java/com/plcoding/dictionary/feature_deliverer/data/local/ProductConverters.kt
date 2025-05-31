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
    fun fromProductJson(json: String): List<Product> {
        return jsonParser.fromJson<ArrayList<Product>>(
            json,
            object : TypeToken<ArrayList<Product>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toProductJson(product: List<Product>): String {
        return jsonParser.toJson(
            product,
            object : TypeToken<ArrayList<Product>>(){}.type
        ) ?: "[]"
    }
}