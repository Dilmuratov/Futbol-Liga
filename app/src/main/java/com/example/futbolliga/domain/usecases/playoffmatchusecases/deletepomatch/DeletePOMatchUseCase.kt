package com.example.futbolliga.domain.usecases.playoffmatchusecases.deletepomatch

import com.example.futbolliga.data.models.PlayOffMatchData

interface DeletePOMatchUseCase {
    suspend fun execute(poMatchData: PlayOffMatchData)
}