package com.example.cleanarchitecturecryptocurrencyapp.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturecryptocurrencyapp.common.Constants.PARAM_COIN_ID
import com.example.cleanarchitecturecryptocurrencyapp.common.Resource
import com.example.cleanarchitecturecryptocurrencyapp.domain.use_case.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
):ViewModel() {

    val _state= mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state
    init {
        savedStateHandle.get<String>(PARAM_COIN_ID)?.let {
            getCoin(it)
        }
    }
    private fun getCoin(coinId:String){
        getCoinUseCase(coinId).onEach {result->
            when(result){
                is Resource.Success ->{
                    _state.value= CoinDetailState(coin= result.data)
                }
                is Resource.Error ->{
                    _state.value = CoinDetailState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading ->{
                    _state.value= CoinDetailState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }
}