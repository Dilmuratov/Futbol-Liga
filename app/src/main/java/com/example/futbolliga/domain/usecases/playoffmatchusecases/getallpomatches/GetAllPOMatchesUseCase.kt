package com.example.futbolliga.domain.usecases.playoffmatchusecases.getallpomatches

import com.example.futbolliga.data.models.PlayOffMatchData
import kotlinx.coroutines.flow.Flow

interface GetAllPOMatchesUseCase {
    suspend fun execute(): Flow<List<PlayOffMatchData>>
}