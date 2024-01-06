package com.example.futbolliga.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.futbolliga.data.models.MatchData
import com.example.futbolliga.data.models.Player

abstract class MainViewModel : ViewModel() {
    abstract suspend fun addMatch(matchData: MatchData)

    abstract suspend fun deleteMatch(matchData: MatchData)

    abstract val allMatchesLiveData: LiveData<List<MatchData>>
    abstract suspend fun getAllMatches()

    abstract suspend fun addPlayer(player: Player)

    abstract suspend fun updatePlayer(player: Player)

    abstract suspend fun deletePlayer(player: Player)

    abstract val allPlayersLiveData: LiveData<List<Player>>
    abstract suspend fun getAllPlayers()
}