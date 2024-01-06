package com.example.futbolliga.domain.usecases.randommatchusecases.getallmatch

import com.example.futbolliga.data.models.RandomMatchData
import kotlinx.coroutines.flow.Flow

interface GetAllMatchesUseCase {
    suspend fun execute(): Flow<List<RandomMatchData>>
}