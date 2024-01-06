package com.example.futbolliga.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "championship_play_off_matches")
data class PlayOffMatchData(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val teamA: String,
    val teamB: String,
    var scoreA: Int = 0,
    var scoreB: Int = 0,
    val playOff: Int,
)
