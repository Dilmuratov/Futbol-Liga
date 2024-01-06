package com.example.futbolliga.domain.usecases.randommatchusecases.addmatch

import com.example.futbolliga.data.models.RandomMatchData
import com.example.futbolliga.domain.MainRepository

class AddMatchUseCaseImpl(private val mainRepository: MainRepository) : AddMatchUseCase {
    override suspend fun execute(randomMatchData: RandomMatchData) = mainRepository.addMatch(randomMatchData)
}