package com.example.futbolliga.domain.usecases.randommatchusecases.deletematch

import com.example.futbolliga.data.models.RandomMatchData

interface DeleteMatchUseCase {
    suspend fun execute(randomMatchData: RandomMatchData)
}