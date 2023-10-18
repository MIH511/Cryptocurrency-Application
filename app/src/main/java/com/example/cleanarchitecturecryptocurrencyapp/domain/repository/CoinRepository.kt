package com.example.cleanarchitecturecryptocurrencyapp.domain.repository

import com.example.cleanarchitecturecryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.example.cleanarchitecturecryptocurrencyapp.data.remote.dto.CoinDto


interface CoinRepository {

    suspend fun getCoins() :List<CoinDto>
    suspend fun getCoinById(coinId:String):CoinDetailDto
}