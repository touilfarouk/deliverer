package com.plcoding.dictionary.core.util

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.plcoding.dictionary.feature_deliverer.data.local.DelivererDao
import com.plcoding.dictionary.feature_deliverer.data.local.ProductConverters
import com.plcoding.dictionary.feature_deliverer.data.local.entity.DelivererEntity
import com.plcoding.dictionary.feature_dictionary.data.local.Converters
import com.plcoding.dictionary.feature_dictionary.data.local.WordInfoDao
import com.plcoding.dictionary.feature_dictionary.data.local.entity.WordInfoEntity

@Database(
    entities = [WordInfoEntity::class, DelivererEntity::class],
    version = 10,
    exportSchema = false
)
@TypeConverters(Converters::class, ProductConverters::class)
abstract class Database : RoomDatabase() {
    abstract val wordInfoDao: WordInfoDao
    abstract val delivererDao: DelivererDao
}