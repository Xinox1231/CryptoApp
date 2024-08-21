package com.example.mycrypto.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycrypto.data.components.Constants
import com.example.mycrypto.domain.model.Coin
import com.example.mycrypto.domain.use_case.GetCoinDetailsUseCase
import com.example.mycrypto.domain.use_case.GetCoinListUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getCoinDetailsUseCase: GetCoinDetailsUseCase,
    private val getCoinListUseCase: GetCoinListUseCase
) : ViewModel() {

    private val _coinsList = MutableLiveData<List<Coin>>()
    val coinsList: LiveData<List<Coin>>
        get() = _coinsList

    fun updateCoinsList() {
        viewModelScope.launch {
            while (true) {
                delay(10 * Constants.MILLIS_IN_SECOND)
                _coinsList.value = getCoinListUseCase.invoke()
            }
        }
    }
}