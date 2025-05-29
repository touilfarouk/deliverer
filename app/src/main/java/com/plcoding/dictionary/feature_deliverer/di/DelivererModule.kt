package com.plcoding.dictionary.feature_deliverer.di

import com.plcoding.dictionary.core.util.Database
import com.plcoding.dictionary.feature_deliverer.data.remote.DelivererApi
import com.plcoding.dictionary.feature_deliverer.data.repository.DelivererInfoRepositoryImpl
import com.plcoding.dictionary.feature_deliverer.domain.repository.DelivererInfoRepository
import com.plcoding.dictionary.feature_deliverer.domain.use_case.GetDelivererInfo
import com.plcoding.dictionary.feature_deliverer.domain.use_case.GetSavedDelivererInfos
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DelivererModule {

    @Provides
    @Singleton
    fun provideDelivererInfoUseCase(repository: DelivererInfoRepository): GetDelivererInfo {
        return GetDelivererInfo(repository)
    }

    @Provides
    @Singleton
    fun provideGetSavedDelivererInfosUseCase(repository: DelivererInfoRepository): GetSavedDelivererInfos {
        return GetSavedDelivererInfos(repository)
    }

    @Provides
    @Singleton
    fun provideDelivererInfoRepository(
        db: Database,
        api: DelivererApi
    ): DelivererInfoRepository {
     return DelivererInfoRepositoryImpl(api, db.delivererDao)
   }

    @Provides
    @Singleton
    fun provideDelivererApi(): DelivererApi {
    return Retrofit.Builder()
        .baseUrl(DelivererApi.BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(DelivererApi::class.java)

    }


}