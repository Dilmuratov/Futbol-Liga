package com.example.futbolliga.domain.usecases.playerusecases.getallplayers

import com.example.futbolliga.domain.MainRepository
import com.example.futbolliga.domain.usecases.playerusecases.getallplayers.GetAllPlayersUseCase

class GetAllPlayersUseCaseImpl(private val mainRepository: MainRepository) : GetAllPlayersUseCase {
    override suspend fun execute() = mainRepository.getAllPlayers()
}