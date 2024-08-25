package com.example.mycrypto.di

import androidx.lifecycle.ViewModel
import com.example.mycrypto.presentation.ApplicationViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(ApplicationViewModel::class)
    @Binds
    fun bindMainViewModel(impl: ApplicationViewModel): ViewModel
}