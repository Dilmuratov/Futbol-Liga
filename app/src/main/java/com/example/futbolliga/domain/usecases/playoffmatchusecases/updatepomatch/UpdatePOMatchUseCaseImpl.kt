package com.example.futbolliga.domain.usecases.playoffmatchusecases.updatepomatch

import com.example.futbolliga.data.models.PlayOffMatchData
import com.example.futbolliga.domain.MainRepository

class UpdatePOMatchUseCaseImpl(private val mainRepository: MainRepository) : UpdatePOMatchUseCase {
    override suspend fun execute(poMatchData: PlayOffMatchData) =
        mainRepository.updatePOMatch(poMatchData)
}