package com.example.futbolliga.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.futbolliga.data.models.RandomMatchData
import com.example.futbolliga.data.models.Player
import com.example.futbolliga.data.models.PlayOffMatchData

@Database(
    entities = [RandomMatchData::class, Player::class, PlayOffMatchData::class],
    version = 4,
    exportSchema = false
)
abstract class MatchDataBase : RoomDatabase() {

    abstract fun getMatchDao(): MatchDao

    companion object {
        const val dataBaseName = "random_db"
    }
}