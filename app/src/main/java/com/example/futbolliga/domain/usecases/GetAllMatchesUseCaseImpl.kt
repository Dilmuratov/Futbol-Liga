package com.example.futbolliga.domain.usecases

import com.example.futbolliga.domain.MainRepository

class GetAllMatchesUseCaseImpl(private val mainRepository: MainRepository) : GetAllMatchesUseCase {
    override suspend fun execute() = mainRepository.getAllMatches()
}