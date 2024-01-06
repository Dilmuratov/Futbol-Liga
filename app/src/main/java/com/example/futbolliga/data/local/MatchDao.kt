package com.example.futbolliga.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.futbolliga.data.models.MatchData
import com.example.futbolliga.data.models.Player
import kotlinx.coroutines.flow.Flow

@Dao
interface MatchDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMatch(matchData: MatchData)

    @Query("SELECT * FROM random_matches")
    suspend fun getAllMatches(): List<MatchData>

    @Delete
    suspend fun deleteMatch(matchData: MatchData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPlayer(player: Player)

    @Query("SELECT * FROM players_championship")
    suspend fun getAllPlayers(): List<Player>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updatePlayer(player: Player)

    @Delete
    suspend fun deletePlayer(player: Player)
}