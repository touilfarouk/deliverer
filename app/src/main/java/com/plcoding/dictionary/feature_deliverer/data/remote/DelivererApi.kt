package com.plcoding.dictionary.feature_deliverer.data.remote

import com.plcoding.dictionary.feature_deliverer.data.remote.dto.DelivererDto
import com.plcoding.dictionary.feature_deliverer.data.remote.dto.DelivererResponseDto
import com.plcoding.dictionary.feature_deliverer.domain.model.Deliverer
import retrofit2.http.GET
import retrofit2.http.Path

interface DelivererApi {
    @GET("/api/deliverers/alimentaire/{name}")
    suspend fun getDelivererInfo(
        @Path("name") name: String
    ): DelivererResponseDto

    companion object {
        const val BASE_URL = ""
    }
}