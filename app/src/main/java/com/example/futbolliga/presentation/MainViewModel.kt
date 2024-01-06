package com.example.futbolliga.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.futbolliga.data.models.PlayOffMatchData
import com.example.futbolliga.data.models.Player
import com.example.futbolliga.data.models.RandomMatchData

abstract class MainViewModel : ViewModel() {
    //Random Match
    abstract suspend fun addMatch(randomMatchData: RandomMatchData)

    abstract suspend fun deleteMatch(randomMatchData: RandomMatchData)

    abstract val allMatchesLiveData: LiveData<List<RandomMatchData>>
    abstract suspend fun getAllMatches()

    //Player

    abstract suspend fun addPlayer(player: Player)

    abstract suspend fun updatePlayer(player: Player)

    abstract suspend fun deletePlayer(player: Player)

    abstract val allPlayersLiveData: LiveData<List<Player>>
    abstract suspend fun getAllPlayers()

    //Play Off

    abstract suspend fun addPOMatch(poMatchData: PlayOffMatchData)
    abstract suspend fun updatePOMatch(poMatchData: PlayOffMatchData)
    abstract suspend fun deletePOMatch(poMatchData: PlayOffMatchData)
    abstract val allPOMatchesLiveData: LiveData<List<PlayOffMatchData>>
    abstract suspend fun getAllPOMatches()
}