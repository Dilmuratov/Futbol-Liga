package com.example.futbolliga.domain

import com.example.futbolliga.data.models.PlayOffMatchData
import com.example.futbolliga.data.models.Player
import com.example.futbolliga.data.models.RandomMatchData
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    suspend fun addMatch(randomMatchData: RandomMatchData)

    suspend fun getAllMatches(): Flow<List<RandomMatchData>>

    suspend fun deleteMatch(randomMatchData: RandomMatchData)

    suspend fun addPlayer(player: Player)

    suspend fun getAllPlayers(): Flow<List<Player>>

    suspend fun updatePlayer(player: Player)

    suspend fun deletePlayer(player: Player)

    suspend fun addPOMatch(playOffMatchData: PlayOffMatchData)

    suspend fun getAllPOMatches(): Flow<List<PlayOffMatchData>>

    suspend fun updatePOMatch(playOffMatchData: PlayOffMatchData)

    suspend fun deletePOMatch(playOffMatchData: PlayOffMatchData)
}