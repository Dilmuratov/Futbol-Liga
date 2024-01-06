package com.example.futbolliga.domain.usecases.playerusecases.deleteplayer

import com.example.futbolliga.data.models.Player

interface DeletePlayerUseCase {
    suspend fun execute(player: Player)
}