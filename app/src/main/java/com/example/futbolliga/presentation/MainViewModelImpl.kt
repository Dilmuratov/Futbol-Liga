package com.example.futbolliga.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.futbolliga.data.models.MatchData
import com.example.futbolliga.domain.usecases.AddMatchUseCase
import com.example.futbolliga.domain.usecases.DeleteMatchUseCase
import com.example.futbolliga.domain.usecases.GetAllMatchesUseCase

class MainViewModelImpl(
    private val addMatchUseCase: AddMatchUseCase,
    private val deleteMatchUseCase: DeleteMatchUseCase,
    private val getAllMatchesUseCase: GetAllMatchesUseCase
) : MainViewModel() {
    override suspend fun addMatch(matchData: MatchData) = addMatchUseCase.execute(matchData)

    override suspend fun deleteMatch(matchData: MatchData) = deleteMatchUseCase.execute(matchData)

    override val allMatchesLiveData: LiveData<List<MatchData>>
        get() = _allMatchesLiveData
    private val _allMatchesLiveData = MutableLiveData<List<MatchData>>()

    override suspend fun getAllMatches() {
        getAllMatchesUseCase.execute().collect {
            _allMatchesLiveData.value = it
        }
    }
}