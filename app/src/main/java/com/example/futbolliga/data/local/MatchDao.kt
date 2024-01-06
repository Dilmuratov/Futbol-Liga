package com.example.futbolliga.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.futbolliga.data.models.PlayOffMatchData
import com.example.futbolliga.data.models.Player
import com.example.futbolliga.data.models.RandomMatchData

@Dao
interface MatchDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMatch(randomMatchData: RandomMatchData)

    @Query("SELECT * FROM random_matches")
    suspend fun getAllMatches(): List<RandomMatchData>

    @Delete
    suspend fun deleteMatch(randomMatchData: RandomMatchData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPlayer(player: Player)

    @Query("SELECT * FROM players_championship")
    suspend fun getAllPlayers(): List<Player>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updatePlayer(player: Player)

    @Delete
    suspend fun deletePlayer(player: Player)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPOMatch(playOffMatchData: PlayOffMatchData)

    @Query("SELECT * FROM championship_play_off_matches")
    suspend fun getAllPOMatched(): List<PlayOffMatchData>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updatePOMatch(playOffMatchData: PlayOffMatchData)

    @Delete
    suspend fun deletePOMatch(playOffMatchData: PlayOffMatchData)
}