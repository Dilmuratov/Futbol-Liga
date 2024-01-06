package com.example.futbolliga.domain.usecases.playoffmatchusecases.deletepomatch

import com.example.futbolliga.data.models.PlayOffMatchData
import com.example.futbolliga.domain.MainRepository

class DeletePOMatchUseCaseImpl(private val mainRepository: MainRepository) : DeletePOMatchUseCase {
    override suspend fun execute(poMatchData: PlayOffMatchData) =
        mainRepository.deletePOMatch(poMatchData)
}