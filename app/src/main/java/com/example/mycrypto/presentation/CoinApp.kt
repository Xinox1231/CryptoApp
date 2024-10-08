package com.example.mycrypto.presentation

import android.app.Application
import com.example.mycrypto.di.DaggerApplicationComponent

class CoinApp: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

}