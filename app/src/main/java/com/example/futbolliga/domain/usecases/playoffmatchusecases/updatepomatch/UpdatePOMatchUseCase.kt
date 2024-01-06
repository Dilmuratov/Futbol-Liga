package com.example.futbolliga.domain.usecases.playoffmatchusecases.updatepomatch

import com.example.futbolliga.data.models.PlayOffMatchData

interface UpdatePOMatchUseCase {
    suspend fun execute(poMatchData: PlayOffMatchData)
}