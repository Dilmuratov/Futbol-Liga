package com.example.futbolliga.domain.usecases.playoffmatchusecases.addpomatch

import com.example.futbolliga.data.models.PlayOffMatchData

interface AddPOMatchUseCase {
    suspend fun execute(poMatchData: PlayOffMatchData)
}