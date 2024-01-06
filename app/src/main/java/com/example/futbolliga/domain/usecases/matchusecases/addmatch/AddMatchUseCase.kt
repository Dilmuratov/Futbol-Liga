package com.example.futbolliga.domain.usecases.matchusecases.addmatch

import com.example.futbolliga.data.models.MatchData

interface AddMatchUseCase {
    suspend fun execute(matchData: MatchData)
}