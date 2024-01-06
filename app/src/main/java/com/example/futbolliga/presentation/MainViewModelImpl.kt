package com.example.futbolliga.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.futbolliga.data.models.PlayOffMatchData
import com.example.futbolliga.data.models.Player
import com.example.futbolliga.data.models.RandomMatchData
import com.example.futbolliga.domain.usecases.playerusecases.addplayer.AddPlayerUseCase
import com.example.futbolliga.domain.usecases.playerusecases.deleteplayer.DeletePlayerUseCase
import com.example.futbolliga.domain.usecases.playerusecases.getallplayers.GetAllPlayersUseCase
import com.example.futbolliga.domain.usecases.playerusecases.updateplayer.UpdatePlayerUseCase
import com.example.futbolliga.domain.usecases.playoffmatchusecases.addpomatch.AddPOMatchUseCase
import com.example.futbolliga.domain.usecases.playoffmatchusecases.deletepomatch.DeletePOMatchUseCase
import com.example.futbolliga.domain.usecases.playoffmatchusecases.getallpomatches.GetAllPOMatchesUseCase
import com.example.futbolliga.domain.usecases.playoffmatchusecases.updatepomatch.UpdatePOMatchUseCase
import com.example.futbolliga.domain.usecases.randommatchusecases.addmatch.AddMatchUseCase
import com.example.futbolliga.domain.usecases.randommatchusecases.deletematch.DeleteMatchUseCase
import com.example.futbolliga.domain.usecases.randommatchusecases.getallmatch.GetAllMatchesUseCase

class MainViewModelImpl(
    private val addMatchUseCase: AddMatchUseCase,
    private val deleteMatchUseCase: DeleteMatchUseCase,
    private val getAllMatchesUseCase: GetAllMatchesUseCase,
    private val addPlayerUseCase: AddPlayerUseCase,
    private val updatePlayerUseCase: UpdatePlayerUseCase,
    private val deletePlayerUseCase: DeletePlayerUseCase,
    private val getAllPlayersUseCase: GetAllPlayersUseCase,
    private val addPOMatchUseCase: AddPOMatchUseCase,
    private val updatePOMatchUseCase: UpdatePOMatchUseCase,
    private val getAllPOMatchesUseCase: GetAllPOMatchesUseCase,
    private val deletePOMatchUseCase: DeletePOMatchUseCase
) : MainViewModel() {

    override suspend fun addMatch(randomMatchData: RandomMatchData) =
        addMatchUseCase.execute(randomMatchData)

    override suspend fun deleteMatch(randomMatchData: RandomMatchData) =
        deleteMatchUseCase.execute(randomMatchData)

    override val allMatchesLiveData: LiveData<List<RandomMatchData>>
        get() = _allMatchesLiveData
    private val _allMatchesLiveData = MutableLiveData<List<RandomMatchData>>()

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


    override suspend fun addPOMatch(poMatchData: PlayOffMatchData) =
        addPOMatchUseCase.execute(poMatchData)

    override suspend fun updatePOMatch(poMatchData: PlayOffMatchData) =
        updatePOMatchUseCase.execute(poMatchData)

    override suspend fun deletePOMatch(poMatchData: PlayOffMatchData) =
        deletePOMatchUseCase.execute(poMatchData)

    override val allPOMatchesLiveData: LiveData<List<PlayOffMatchData>>
        get() = _allPOMatchesLiveData
    private val _allPOMatchesLiveData = MutableLiveData<List<PlayOffMatchData>>()

    override suspend fun getAllPOMatches() {
        getAllPOMatchesUseCase.execute().collect {
            _allPOMatchesLiveData.value = it
        }
    }
}