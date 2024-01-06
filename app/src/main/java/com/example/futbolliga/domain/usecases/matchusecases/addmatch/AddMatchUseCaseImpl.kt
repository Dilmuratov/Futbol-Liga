package com.example.futbolliga.domain.usecases.matchusecases.addmatch

import com.example.futbolliga.data.models.MatchData
import com.example.futbolliga.domain.MainRepository

class AddMatchUseCaseImpl(private val mainRepository: MainRepository) : AddMatchUseCase {
    override suspend fun execute(matchData: MatchData) = mainRepository.addMatch(matchData)
}