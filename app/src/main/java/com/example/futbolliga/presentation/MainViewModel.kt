package com.example.futbolliga.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.futbolliga.data.models.MatchData

abstract class MainViewModel : ViewModel() {
    abstract suspend fun addMatch(matchData: MatchData)

    abstract suspend fun deleteMatch(matchData: MatchData)

    abstract val allMatchesLiveData: LiveData<List<MatchData>>
    abstract suspend fun getAllMatches()
}