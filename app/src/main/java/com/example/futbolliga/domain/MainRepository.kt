package com.example.futbolliga.domain

import com.example.futbolliga.data.models.MatchData
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    suspend fun addMatch(matchData: MatchData)

    suspend fun getAllMatches(): Flow<List<MatchData>>

    suspend fun deleteMatch(matchData: MatchData)
}