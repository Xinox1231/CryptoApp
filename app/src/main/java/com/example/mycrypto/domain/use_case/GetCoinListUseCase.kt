package com.example.mycrypto.domain.use_case

import com.example.mycrypto.domain.CoinRepository
import com.example.mycrypto.domain.model.Coin

class GetCoinListUseCase(
    private val repository: CoinRepository
){
    operator fun invoke(): List<Coin> = repository.getCoinList()
}