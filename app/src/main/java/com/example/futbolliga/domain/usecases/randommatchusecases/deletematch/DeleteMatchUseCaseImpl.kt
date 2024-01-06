package com.example.futbolliga.domain.usecases.randommatchusecases.deletematch

import com.example.futbolliga.data.models.RandomMatchData
import com.example.futbolliga.domain.MainRepository

class DeleteMatchUseCaseImpl(private val mainRepository: MainRepository) : DeleteMatchUseCase {
    override suspend fun execute(randomMatchData: RandomMatchData) = mainRepository.deleteMatch(randomMatchData)
}