package com.example.futbolliga.domain.usecases.randommatchusecases.getallmatch

import com.example.futbolliga.domain.MainRepository

class GetAllMatchesUseCaseImpl(private val mainRepository: MainRepository) : GetAllMatchesUseCase {
    override suspend fun execute() = mainRepository.getAllMatches()
}