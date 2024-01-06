package com.example.futbolliga.domain.usecases.playoffmatchusecases.getallpomatches

import com.example.futbolliga.data.models.PlayOffMatchData
import com.example.futbolliga.domain.MainRepository
import kotlinx.coroutines.flow.Flow

class GetAllPOMatchesUseCaseImpl(private val mainRepository: MainRepository) :
    GetAllPOMatchesUseCase {
    override suspend fun execute(): Flow<List<PlayOffMatchData>> = mainRepository.getAllPOMatches()
}