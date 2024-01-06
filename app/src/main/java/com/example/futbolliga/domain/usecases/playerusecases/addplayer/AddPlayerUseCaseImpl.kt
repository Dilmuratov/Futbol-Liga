package com.example.futbolliga.domain.usecases.playerusecases.addplayer

import com.example.futbolliga.data.models.Player
import com.example.futbolliga.domain.MainRepository

class AddPlayerUseCaseImpl(private val mainRepository: MainRepository): AddPlayerUseCase {
    override suspend fun execute(player: Player) = mainRepository.addPlayer(player)
}