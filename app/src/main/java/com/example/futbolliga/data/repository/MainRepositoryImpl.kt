package com.example.futbolliga.data.repository

import com.example.futbolliga.data.local.MatchDao
import com.example.futbolliga.data.models.MatchData
import com.example.futbolliga.domain.MainRepository
import kotlinx.coroutines.flow.flow

class MainRepositoryImpl(private val dao: MatchDao) : MainRepository {

    override suspend fun addMatch(matchData: MatchData) = dao.addMatch(matchData)

    override suspend fun getAllMatches() = flow {
        emit(dao.getAllMatches())
    }

    override suspend fun deleteMatch(matchData: MatchData) = dao.deleteMatch(matchData)
}