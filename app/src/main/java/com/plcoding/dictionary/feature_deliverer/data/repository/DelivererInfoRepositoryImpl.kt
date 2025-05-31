package com.plcoding.dictionary.feature_deliverer.data.repository

import android.util.Log
import com.plcoding.dictionary.core.util.Resource
import com.plcoding.dictionary.feature_deliverer.data.local.DelivererDao
import com.plcoding.dictionary.feature_deliverer.data.remote.DelivererApi
import com.plcoding.dictionary.feature_deliverer.domain.model.Deliverer
import com.plcoding.dictionary.feature_deliverer.domain.repository.DelivererInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class DelivererInfoRepositoryImpl(
    private val api: DelivererApi,
    private val dao: DelivererDao

): DelivererInfoRepository {
    override fun getDelivererInfo(name: String): Flow<Resource<List<Deliverer>>> = flow {
        emit(Resource.Loading())

        val delivererInfos = dao.getDelivererInfos(name).map { it.toDeliverer() }
        emit(Resource.Loading(data = delivererInfos))
        try {
            val remoteDelivererInfos = api.getDelivererInfo(name).deliverer
            dao.deleteDelivererInfos(remoteDelivererInfos.map { it.name })
            dao.insertDelivererInfos(remoteDelivererInfos.map { it.toDelivererEntity() })
        } catch(e: HttpException) {
            emit(Resource.Error(
                message = "Oops, something went wrong!",
                data = delivererInfos
            ))
        } catch(e: IOException) {
            emit(Resource.Error(
                message = "Couldn't reach server, check your internet connection.",
                data = delivererInfos
            ))
        }
        val newDelivererInfos = dao.getDelivererInfos(name).map { it.toDeliverer() }
        emit(Resource.Success(newDelivererInfos))

    }

    override fun getAllSavedDeliverers(): Flow<List<Deliverer>> = flow {
        val infos = dao.getAllDelivererInfos().map { it.toDeliverer() }
        emit(infos)

    }

}