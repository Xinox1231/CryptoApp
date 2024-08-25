package com.example.mycrypto.domain.use_case

import com.example.mycrypto.domain.CoinRepository
import javax.inject.Inject

class LoadDataFromNetworkUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    suspend operator fun invoke(){
        repository.loadData()
    }
}