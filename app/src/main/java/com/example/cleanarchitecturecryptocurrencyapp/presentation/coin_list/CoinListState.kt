package com.example.cleanarchitecturecryptocurrencyapp.presentation.coin_list

import com.example.cleanarchitecturecryptocurrencyapp.domain.model.Coin

data class CoinListState (
    val isLoading: Boolean= false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)