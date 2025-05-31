package com.plcoding.dictionary.core.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import com.plcoding.dictionary.core.util.Database
import com.plcoding.dictionary.core.util.GsonParser
import com.plcoding.dictionary.core.util.JsonParser
import com.plcoding.dictionary.feature_deliverer.data.local.ProductConverters
import com.plcoding.dictionary.feature_dictionary.data.local.Converters
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideProductConverters(jsonParser: JsonParser): ProductConverters {
        return ProductConverters(jsonParser)
    }
    @Provides
    @Singleton
    fun provideDatabase(app: Application): Database {
        return Room.databaseBuilder(
            app,
            Database::class.java,
            "word_db"
        )
            .fallbackToDestructiveMigration()  // <-- Added this line
            .addTypeConverter(Converters(GsonParser(Gson())))
            .addTypeConverter(ProductConverters(GsonParser(Gson())))
            .build()
    }

}