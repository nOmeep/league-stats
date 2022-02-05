package com.example.lolstats.di

import android.app.Application
import androidx.room.Room
import com.example.lolstats.api.DDragonApi
import com.example.lolstats.db.ChampionsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDDragonApi(): DDragonApi =
        Retrofit.Builder()
            .baseUrl(DDragonApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DDragonApi::class.java)

    @Provides
    @Singleton
    fun provideChampionsDatabase(app: Application) =
        Room.databaseBuilder(app,  ChampionsDatabase::class.java, "champions_database")
            .build()
}