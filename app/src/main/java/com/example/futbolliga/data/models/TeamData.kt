package com.example.futbolliga.data.models

data class TeamData(
    var rank: Int = 0,
    val teamName: String,
    val teamLogo: String,
    val country: String,
    var stats: String = ""
)
