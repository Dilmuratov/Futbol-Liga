package com.example.futbolliga.domain.usecases.playerusecases.getallplayers

import com.example.futbolliga.data.models.Player
import kotlinx.coroutines.flow.Flow

interface GetAllPlayersUseCase {
    suspend fun execute(): Flow<List<Player>>
}