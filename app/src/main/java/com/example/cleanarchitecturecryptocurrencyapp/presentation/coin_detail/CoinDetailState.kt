package com.example.cleanarchitecturecryptocurrencyapp.presentation.coin_detail

import com.example.cleanarchitecturecryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState (
    val isLoading: Boolean= false,
    val coin: CoinDetail ?=null,
    val error: String = ""
)