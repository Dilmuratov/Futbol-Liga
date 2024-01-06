package com.example.futbolliga.domain.usecases.randommatchusecases.addmatch

import com.example.futbolliga.data.models.RandomMatchData

interface AddMatchUseCase {
    suspend fun execute(randomMatchData: RandomMatchData)
}