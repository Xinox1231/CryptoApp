package com.example.mycrypto.domain.use_case

import androidx.lifecycle.LiveData
import com.example.mycrypto.domain.CoinRepository
import com.example.mycrypto.domain.model.CoinInfo
import javax.inject.Inject

class GetCoinDetailsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(fSym: String): LiveData<CoinInfo> =
        repository.getCoinDetails(fSym)
}