package com.example.futbolliga.domain.usecases

import com.example.futbolliga.data.models.MatchData

interface DeleteMatchUseCase {
    suspend fun execute(matchData: MatchData)
}