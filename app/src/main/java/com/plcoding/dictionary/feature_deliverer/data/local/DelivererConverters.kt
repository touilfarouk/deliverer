package com.plcoding.dictionary.feature_deliverer.data.local
import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.plcoding.dictionary.core.util.JsonParser
import com.plcoding.dictionary.feature_deliverer.domain.model.Deliverer

@ProvidedTypeConverter
class DelivererConverters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromDeliverersJson(json: String): List<Deliverer> {
        return jsonParser.fromJson<ArrayList<Deliverer>>(
            json,
            object : TypeToken<ArrayList<Deliverer>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toDeliverersJson(deliverers: List<Deliverer>): String {
        return jsonParser.toJson(
            deliverers,
            object : TypeToken<ArrayList<Deliverer>>(){}.type
        ) ?: "[]"
    }
}