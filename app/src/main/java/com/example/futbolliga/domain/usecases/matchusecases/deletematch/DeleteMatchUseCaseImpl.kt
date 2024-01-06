package com.example.futbolliga.domain.usecases.matchusecases.deletematch

import com.example.futbolliga.data.models.MatchData
import com.example.futbolliga.domain.MainRepository

class DeleteMatchUseCaseImpl(private val mainRepository: MainRepository) : DeleteMatchUseCase {
    override suspend fun execute(matchData: MatchData) = mainRepository.deleteMatch(matchData)
}