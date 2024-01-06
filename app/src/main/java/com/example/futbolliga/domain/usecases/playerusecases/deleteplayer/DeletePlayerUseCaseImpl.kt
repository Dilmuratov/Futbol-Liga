package com.example.futbolliga.domain.usecases.playerusecases.deleteplayer

import com.example.futbolliga.data.models.Player
import com.example.futbolliga.domain.MainRepository

class DeletePlayerUseCaseImpl(private val mainRepository: MainRepository) : DeletePlayerUseCase {
    override suspend fun execute(player: Player) = mainRepository.deletePlayer(player)
}