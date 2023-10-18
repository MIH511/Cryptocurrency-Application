package com.example.cleanarchitecturecryptocurrencyapp.domain.use_case.get_coin

import com.example.cleanarchitecturecryptocurrencyapp.common.Resource
import com.example.cleanarchitecturecryptocurrencyapp.data.remote.dto.toCoinDetail
import com.example.cleanarchitecturecryptocurrencyapp.domain.model.CoinDetail
import com.example.cleanarchitecturecryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coinDetail=repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coinDetail))
        }catch (e: HttpException){
            emit(Resource.Error<CoinDetail>(message = e.localizedMessage?: "An unexpected error occurred"))
        }catch (e : IOException){
            emit(Resource.Error<CoinDetail>(message = "Couldn't reach server. Check your internet connection"))
        }
    }
}