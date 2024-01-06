package com.example.futbolliga.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.futbolliga.data.models.MatchData
import com.example.futbolliga.data.models.Player
import com.example.futbolliga.domain.usecases.matchusecases.addmatch.AddMatchUseCase
import com.example.futbolliga.domain.usecases.matchusecases.deletematch.DeleteMatchUseCase
import com.example.futbolliga.domain.usecases.matchusecases.getallmatch.GetAllMatchesUseCase
import com.example.futbolliga.domain.usecases.playerusecases.addplayer.AddPlayerUseCase
import com.example.futbolliga.domain.usecases.playerusecases.deleteplayer.DeletePlayerUseCase
import com.example.futbolliga.domain.usecases.playerusecases.getallplayers.GetAllPlayersUseCase
import com.example.futbolliga.domain.usecases.playerusecases.updateplayer.UpdatePlayerUseCase

class MainViewModelImpl(
    private val addMatchUseCase: AddMatchUseCase,
    private val deleteMatchUseCase: DeleteMatchUseCase,
    private val getAllMatchesUseCase: GetAllMatchesUseCase,
    private val addPlayerUseCase: AddPlayerUseCase,
    private val updatePlayerUseCase: UpdatePlayerUseCase,
    private val deletePlayerUseCase: DeletePlayerUseCase,
    private val getAllPlayersUseCase: GetAllPlayersUseCase
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

    override suspend fun addPlayer(player: Player) = addPlayerUseCase.execute(player)

    override suspend fun updatePlayer(player: Player) = updatePlayerUseCase.execute(player)

    override suspend fun deletePlayer(player: Player) = deletePlayerUseCase.execute(player)

    override val allPlayersLiveData: LiveData<List<Player>>
        get() = _allPlayersLiveData
    private val _allPlayersLiveData = MutableLiveData<List<Player>>()
    override suspend fun getAllPlayers() {
        getAllPlayersUseCase.execute().collect {
            _allPlayersLiveData.value = it
        }
    }
}