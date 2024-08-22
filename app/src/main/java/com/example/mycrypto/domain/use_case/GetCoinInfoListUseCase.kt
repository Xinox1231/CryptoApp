package com.example.mycrypto.domain.use_case

import androidx.lifecycle.LiveData
import com.example.mycrypto.domain.CoinRepository
import com.example.mycrypto.domain.model.CoinInfo
import javax.inject.Inject

class GetCoinInfoListUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): LiveData<List<CoinInfo>> = repository.getCoinList()
}