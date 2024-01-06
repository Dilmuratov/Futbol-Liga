package com.example.futbolliga.domain.usecases.playerusecases.updateplayer

import com.example.futbolliga.data.models.Player

interface UpdatePlayerUseCase {
    suspend fun execute(player: Player)
}