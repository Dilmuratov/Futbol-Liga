package com.example.futbolliga.di

import com.example.futbolliga.domain.usecases.AddMatchUseCase
import com.example.futbolliga.domain.usecases.AddMatchUseCaseImpl
import com.example.futbolliga.domain.usecases.DeleteMatchUseCase
import com.example.futbolliga.domain.usecases.DeleteMatchUseCaseImpl
import com.example.futbolliga.domain.usecases.GetAllMatchesUseCase
import com.example.futbolliga.domain.usecases.GetAllMatchesUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory<AddMatchUseCase> {
        AddMatchUseCaseImpl(mainRepository = get())
    }

    factory<DeleteMatchUseCase> {
        DeleteMatchUseCaseImpl(mainRepository = get())
    }

    factory<GetAllMatchesUseCase> {
        GetAllMatchesUseCaseImpl(mainRepository = get())
    }
}