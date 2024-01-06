package com.example.futbolliga.di

import com.example.futbolliga.domain.usecases.matchusecases.addmatch.AddMatchUseCase
import com.example.futbolliga.domain.usecases.matchusecases.addmatch.AddMatchUseCaseImpl
import com.example.futbolliga.domain.usecases.matchusecases.deletematch.DeleteMatchUseCase
import com.example.futbolliga.domain.usecases.matchusecases.deletematch.DeleteMatchUseCaseImpl
import com.example.futbolliga.domain.usecases.matchusecases.getallmatch.GetAllMatchesUseCase
import com.example.futbolliga.domain.usecases.matchusecases.getallmatch.GetAllMatchesUseCaseImpl
import com.example.futbolliga.domain.usecases.playerusecases.addplayer.AddPlayerUseCase
import com.example.futbolliga.domain.usecases.playerusecases.addplayer.AddPlayerUseCaseImpl
import com.example.futbolliga.domain.usecases.playerusecases.deleteplayer.DeletePlayerUseCase
import com.example.futbolliga.domain.usecases.playerusecases.deleteplayer.DeletePlayerUseCaseImpl
import com.example.futbolliga.domain.usecases.playerusecases.getallplayers.GetAllPlayersUseCase
import com.example.futbolliga.domain.usecases.playerusecases.getallplayers.GetAllPlayersUseCaseImpl
import com.example.futbolliga.domain.usecases.playerusecases.updateplayer.UpdatePlayerUseCase
import com.example.futbolliga.domain.usecases.playerusecases.updateplayer.UpdatePlayerUseCaseImpl
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
    factory<AddPlayerUseCase> {
        AddPlayerUseCaseImpl(mainRepository = get())
    }
    factory<UpdatePlayerUseCase> {
        UpdatePlayerUseCaseImpl(mainRepository = get())
    }
    factory<DeletePlayerUseCase> {
        DeletePlayerUseCaseImpl(mainRepository = get())
    }
    factory<GetAllPlayersUseCase> {
        GetAllPlayersUseCaseImpl(mainRepository = get())
    }


}