package com.example.mycrypto.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycrypto.domain.model.CoinInfo
import com.example.mycrypto.domain.use_case.GetCoinDetailsUseCase
import com.example.mycrypto.domain.use_case.GetCoinInfoListUseCase
import com.example.mycrypto.domain.use_case.LoadDataFromNetworkUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class ApplicationViewModel @Inject constructor(
    private val getCoinDetailsUseCase: GetCoinDetailsUseCase,
    private val getCoinInfoListUseCase: GetCoinInfoListUseCase,
    private val loadDataFromNetworkUseCase: LoadDataFromNetworkUseCase,
) : ViewModel() {

    private val _coinInfoList = getCoinInfoListUseCase()
    val coinInfoList: LiveData<List<CoinInfo>>
        get() = _coinInfoList

    init {
        viewModelScope.launch {
            loadDataFromNetworkUseCase()
        }
    }

    fun getDetailedInfo(fSyms: String): LiveData<CoinInfo> = getCoinDetailsUseCase(fSyms)
}