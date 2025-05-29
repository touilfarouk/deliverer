package com.plcoding.dictionary.feature_deliverer.data.remote

import com.plcoding.dictionary.feature_deliverer.data.remote.dto.DelivererDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DelivererApi {
    @GET("/api/deliverers/{name}")
    suspend fun getDelivererInfo(
        @Path("name") name: String
    ): List<DelivererDto>

    companion object {
        const val BASE_URL = "https://onta.dz/"
    }
}