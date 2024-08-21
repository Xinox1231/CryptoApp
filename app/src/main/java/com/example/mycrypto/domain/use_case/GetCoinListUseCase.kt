package com.example.mycrypto.domain.use_case

import com.example.mycrypto.domain.CoinRepository
import com.example.mycrypto.domain.model.Coin
import javax.inject.Inject

class GetCoinListUseCase @Inject constructor(
    private val repository: CoinRepository
){
    suspend operator fun invoke(): List<Coin> = repository.getCoinList()
}