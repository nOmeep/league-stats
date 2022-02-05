package com.example.lolstats.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lolstats.api.items.Champion

@Database(entities = [Champion::class], version = 1)
abstract class ChampionsDatabase : RoomDatabase() {
    abstract fun championsDao(): ChampionsDao
}