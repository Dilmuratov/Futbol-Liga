package com.example.futbolliga.domain.usecases.playerusecases.addplayer

import com.example.futbolliga.data.models.Player

interface AddPlayerUseCase {
    suspend fun execute(player: Player)
}