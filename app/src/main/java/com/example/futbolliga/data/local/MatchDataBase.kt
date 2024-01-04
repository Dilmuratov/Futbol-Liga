package com.example.futbolliga.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.futbolliga.data.models.MatchData

@Database(
    entities = [MatchData::class],
    version = 1,
    exportSchema = false
)
abstract class MatchDataBase : RoomDatabase() {

    abstract fun getMatchDao(): MatchDao

    companion object {
        const val dataBaseName = "random_db"
    }
}