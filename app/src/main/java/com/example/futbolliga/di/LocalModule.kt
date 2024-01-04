package com.example.futbolliga.di

import com.example.futbolliga.data.local.MatchDao
import com.example.futbolliga.data.local.MatchDataBase
import org.koin.dsl.module

val localModule = module {
    single<MatchDao> {
        get<MatchDataBase>().getMatchDao()
    }
}