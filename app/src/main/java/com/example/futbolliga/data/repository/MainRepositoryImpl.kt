package com.example.futbolliga.data.repository

import com.example.futbolliga.data.local.MatchDao
import com.example.futbolliga.data.models.MatchData
import com.example.futbolliga.data.models.Player
import com.example.futbolliga.domain.MainRepository
import kotlinx.coroutines.flow.flow

class MainRepositoryImpl(private val dao: MatchDao) : MainRepository {

    override suspend fun addMatch(matchData: MatchData) = dao.addMatch(matchData)

    override suspend fun getAllMatches() = flow {
        emit(dao.getAllMatches())
    }

    override suspend fun deleteMatch(matchData: MatchData) = dao.deleteMatch(matchData)

    override suspend fun addPlayer(player: Player) = dao.addPlayer(player)

    override suspend fun getAllPlayers() = flow {
        emit(dao.getAllPlayers())
    }

    override suspend fun updatePlayer(player: Player) = dao.updatePlayer(player)

    override suspend fun deletePlayer(player: Player) = dao.deletePlayer(player)
}