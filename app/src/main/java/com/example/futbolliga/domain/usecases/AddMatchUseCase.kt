package com.example.futbolliga.domain.usecases

import com.example.futbolliga.data.models.MatchData

interface AddMatchUseCase {
    suspend fun execute(matchData: MatchData)
}