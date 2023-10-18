package com.example.cleanarchitecturecryptocurrencyapp.di

import com.example.cleanarchitecturecryptocurrencyapp.common.Constants.BASE_URL
import com.example.cleanarchitecturecryptocurrencyapp.data.remote.CoinPaprikaApi
import com.example.cleanarchitecturecryptocurrencyapp.data.repository.CoinRepositoryImpl
import com.example.cleanarchitecturecryptocurrencyapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi):CoinRepository{
        return CoinRepositoryImpl(api)
    }
}