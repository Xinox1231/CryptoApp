package com.example.mycrypto.presentation

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycrypto.data.components.Constants
import com.example.mycrypto.domain.model.CoinInfo
import com.example.mycrypto.domain.use_case.GetCoinDetailsUseCase
import com.example.mycrypto.domain.use_case.GetCoinInfoListUseCase
import com.example.mycrypto.domain.use_case.LoadDataFromNetworkUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getCoinDetailsUseCase: GetCoinDetailsUseCase,
    private val getCoinInfoListUseCase: GetCoinInfoListUseCase,
    private val loadDataFromNetworkUseCase: LoadDataFromNetworkUseCase,
    private val application: Application
) : ViewModel() {

    private val _coinInfoList = getCoinInfoListUseCase()
    val coinInfoList: LiveData<List<CoinInfo>>
        get() = _coinInfoList

    init {
        viewModelScope.launch {
            loadDataFromNetworkUseCase()
        }
    }


}