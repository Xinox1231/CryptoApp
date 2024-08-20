package com.example.mycrypto.domain.use_case

import com.example.mycrypto.domain.CoinRepository
import com.example.mycrypto.domain.model.CoinDetails

class GetCoinDetailsUseCase(
    private val repository: CoinRepository
) {
    operator fun invoke(id: String): List<CoinDetails> = repository.getCoinDetailsById(id)
}