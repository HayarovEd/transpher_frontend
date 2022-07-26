package com.edurda77.transpher_frontend.coin

import com.edurda77.transpher_frontend.ui.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainActivityViewModel() }
}