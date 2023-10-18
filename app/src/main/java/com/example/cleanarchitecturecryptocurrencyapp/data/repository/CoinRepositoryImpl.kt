package com.example.cleanarchitecturecryptocurrencyapp.data.repository

import com.example.cleanarchitecturecryptocurrencyapp.data.remote.CoinPaprikaApi
import com.example.cleanarchitecturecryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.example.cleanarchitecturecryptocurrencyapp.data.remote.dto.CoinDto
import com.example.cleanarchitecturecryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api:CoinPaprikaApi
) :CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoin(coinId)
    }


}