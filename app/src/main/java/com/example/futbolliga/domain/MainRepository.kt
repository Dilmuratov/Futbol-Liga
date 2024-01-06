package com.example.futbolliga.domain

import com.example.futbolliga.data.models.MatchData
import com.example.futbolliga.data.models.Player
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    suspend fun addMatch(matchData: MatchData)

    suspend fun getAllMatches(): Flow<List<MatchData>>

    suspend fun deleteMatch(matchData: MatchData)

    suspend fun addPlayer(player: Player)

    suspend fun getAllPlayers(): Flow<List<Player>>

    suspend fun updatePlayer(player: Player)

    suspend fun deletePlayer(player: Player)
}