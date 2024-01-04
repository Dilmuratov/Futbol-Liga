package com.example.futbolliga.di

import com.example.futbolliga.presentation.MainViewModel
import com.example.futbolliga.presentation.MainViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MainViewModel> {
        MainViewModelImpl(
            addMatchUseCase = get(),
            deleteMatchUseCase = get(),
            getAllMatchesUseCase = get()
        )
    }
}