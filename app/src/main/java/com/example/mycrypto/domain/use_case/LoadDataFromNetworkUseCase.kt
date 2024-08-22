package com.example.mycrypto.domain.use_case

import com.example.mycrypto.domain.CoinRepository

class LoadDataFromNetworkUseCase(
    private val repository: CoinRepository
) {
    suspend operator fun invoke(){
        repository.loadData()
    }
}