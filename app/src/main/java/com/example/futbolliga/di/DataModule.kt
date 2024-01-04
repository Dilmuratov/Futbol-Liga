package com.example.futbolliga.di

import androidx.room.Room
import com.example.futbolliga.data.local.MatchDataBase
import com.example.futbolliga.data.repository.MainRepositoryImpl
import com.example.futbolliga.domain.MainRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single<MainRepository> {
        MainRepositoryImpl(
            dao = get()
        )
    }

    single<MatchDataBase> {
        Room.databaseBuilder(
            androidContext(),
            MatchDataBase::class.java,
            MatchDataBase.dataBaseName
        ).build()
    }
}