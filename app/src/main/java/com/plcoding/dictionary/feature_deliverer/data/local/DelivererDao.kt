package com.plcoding.dictionary.feature_deliverer.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.plcoding.dictionary.feature_deliverer.data.local.entity.DelivererEntity


@Dao
interface DelivererDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDelivererInfos(infos: List<DelivererEntity>)

    @Query("DELETE FROM DelivererEntity WHERE name IN(:names)")
    suspend fun deleteDelivererInfos(names: List<String>)

    @Query("SELECT * FROM DelivererEntity WHERE name LIKE '%' || :name || '%'")
    suspend fun getDelivererInfos(name: String): List<DelivererEntity>

    @Query("SELECT * FROM DelivererEntity")
    suspend fun getAllDelivererInfos(): List<DelivererEntity>
}