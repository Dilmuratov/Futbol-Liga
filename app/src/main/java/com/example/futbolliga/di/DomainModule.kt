package com.example.futbolliga.di

import com.example.futbolliga.domain.usecases.playerusecases.addplayer.AddPlayerUseCase
import com.example.futbolliga.domain.usecases.playerusecases.addplayer.AddPlayerUseCaseImpl
import com.example.futbolliga.domain.usecases.playerusecases.deleteplayer.DeletePlayerUseCase
import com.example.futbolliga.domain.usecases.playerusecases.deleteplayer.DeletePlayerUseCaseImpl
import com.example.futbolliga.domain.usecases.playerusecases.getallplayers.GetAllPlayersUseCase
import com.example.futbolliga.domain.usecases.playerusecases.getallplayers.GetAllPlayersUseCaseImpl
import com.example.futbolliga.domain.usecases.playerusecases.updateplayer.UpdatePlayerUseCase
import com.example.futbolliga.domain.usecases.playerusecases.updateplayer.UpdatePlayerUseCaseImpl
import com.example.futbolliga.domain.usecases.playoffmatchusecases.addpomatch.AddPOMatchUseCase
import com.example.futbolliga.domain.usecases.playoffmatchusecases.addpomatch.AddPOMatchUseCaseImpl
import com.example.futbolliga.domain.usecases.playoffmatchusecases.deletepomatch.DeletePOMatchUseCase
import com.example.futbolliga.domain.usecases.playoffmatchusecases.deletepomatch.DeletePOMatchUseCaseImpl
import com.example.futbolliga.domain.usecases.playoffmatchusecases.getallpomatches.GetAllPOMatchesUseCase
import com.example.futbolliga.domain.usecases.playoffmatchusecases.getallpomatches.GetAllPOMatchesUseCaseImpl
import com.example.futbolliga.domain.usecases.playoffmatchusecases.updatepomatch.UpdatePOMatchUseCase
import com.example.futbolliga.domain.usecases.playoffmatchusecases.updatepomatch.UpdatePOMatchUseCaseImpl
import com.example.futbolliga.domain.usecases.randommatchusecases.addmatch.AddMatchUseCase
import com.example.futbolliga.domain.usecases.randommatchusecases.addmatch.AddMatchUseCaseImpl
import com.example.futbolliga.domain.usecases.randommatchusecases.deletematch.DeleteMatchUseCase
import com.example.futbolliga.domain.usecases.randommatchusecases.deletematch.DeleteMatchUseCaseImpl
import com.example.futbolliga.domain.usecases.randommatchusecases.getallmatch.GetAllMatchesUseCase
import com.example.futbolliga.domain.usecases.randommatchusecases.getallmatch.GetAllMatchesUseCaseImpl
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

    factory<AddPOMatchUseCase> {
        AddPOMatchUseCaseImpl(mainRepository = get())
    }

    factory<UpdatePOMatchUseCase> {
        UpdatePOMatchUseCaseImpl(mainRepository = get())
    }

    factory<GetAllPOMatchesUseCase> {
        GetAllPOMatchesUseCaseImpl(mainRepository = get())
    }

    factory<DeletePOMatchUseCase> {
        DeletePOMatchUseCaseImpl(mainRepository = get())
    }
}
