package com.example.futbolliga.domain.usecases.playerusecases.updateplayer

import com.example.futbolliga.data.models.Player
import com.example.futbolliga.domain.MainRepository

class UpdatePlayerUseCaseImpl(private val mainRepository: MainRepository) : UpdatePlayerUseCase {
    override suspend fun execute(player: Player) = mainRepository.updatePlayer(player)
}