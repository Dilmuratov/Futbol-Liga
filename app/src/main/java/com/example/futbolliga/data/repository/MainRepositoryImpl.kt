package com.example.futbolliga.data.repository

import com.example.futbolliga.data.local.MatchDao
import com.example.futbolliga.data.models.PlayOffMatchData
import com.example.futbolliga.data.models.Player
import com.example.futbolliga.data.models.RandomMatchData
import com.example.futbolliga.domain.MainRepository
import kotlinx.coroutines.flow.flow

class MainRepositoryImpl(private val dao: MatchDao) : MainRepository {

    override suspend fun addMatch(randomMatchData: RandomMatchData) = dao.addMatch(randomMatchData)

    override suspend fun getAllMatches() = flow {
        emit(dao.getAllMatches())
    }

    override suspend fun deleteMatch(randomMatchData: RandomMatchData) =
        dao.deleteMatch(randomMatchData)

    override suspend fun addPlayer(player: Player) = dao.addPlayer(player)

    override suspend fun getAllPlayers() = flow {
        emit(dao.getAllPlayers())
    }

    override suspend fun updatePlayer(player: Player) = dao.updatePlayer(player)

    override suspend fun deletePlayer(player: Player) = dao.deletePlayer(player)

    override suspend fun addPOMatch(playOffMatchData: PlayOffMatchData) =
        dao.addPOMatch(playOffMatchData)

    override suspend fun getAllPOMatches() = flow {
        emit(dao.getAllPOMatched())
    }

    override suspend fun updatePOMatch(playOffMatchData: PlayOffMatchData) =
        dao.updatePOMatch(playOffMatchData)

    override suspend fun deletePOMatch(playOffMatchData: PlayOffMatchData) {
        dao.deletePOMatch(playOffMatchData)
    }
}