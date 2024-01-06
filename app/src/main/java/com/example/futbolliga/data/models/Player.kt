package com.example.futbolliga.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "players_championship")
data class Player(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val name: String
)
