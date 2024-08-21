package com.example.mycrypto.domain.use_case

import com.example.mycrypto.domain.CoinRepository
import com.example.mycrypto.domain.model.CoinDetails
import javax.inject.Inject

class GetCoinDetailsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    suspend operator fun invoke(id: String): CoinDetails = repository.getCoinDetailsById(id)
}