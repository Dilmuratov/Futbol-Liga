package com.example.futbolliga.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.futbolliga.data.models.MatchData
import kotlinx.coroutines.flow.Flow

@Dao
interface MatchDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMatch(matchData: MatchData)

    @Query("SELECT * FROM random_matches")
    suspend fun getAllMatches(): List<MatchData>

    @Delete
    suspend fun deleteMatch(matchData: MatchData)
}