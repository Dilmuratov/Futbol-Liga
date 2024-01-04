package com.example.futbolliga.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "random_matches")
data class MatchData(
    @PrimaryKey
    val id: Int,
    val teamA: String,
    val teamB: String,
    val scoreA: Int,
    val scoreB: Int
)
