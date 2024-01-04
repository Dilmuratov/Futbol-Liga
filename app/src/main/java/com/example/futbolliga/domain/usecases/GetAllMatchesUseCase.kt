package com.example.futbolliga.domain.usecases

import com.example.futbolliga.data.models.MatchData
import kotlinx.coroutines.flow.Flow

interface GetAllMatchesUseCase {
    suspend fun execute(): Flow<List<MatchData>>
}