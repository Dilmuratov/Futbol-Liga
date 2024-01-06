package com.example.futbolliga.domain.usecases.playoffmatchusecases.addpomatch

import com.example.futbolliga.data.models.PlayOffMatchData
import com.example.futbolliga.domain.MainRepository

class AddPOMatchUseCaseImpl(private val mainRepository: MainRepository) : AddPOMatchUseCase {
    override suspend fun execute(poMatchData: PlayOffMatchData) =
        mainRepository.addPOMatch(poMatchData)
}