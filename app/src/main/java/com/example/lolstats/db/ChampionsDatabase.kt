package com.example.lolstats.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.lolstats.api.items.Champion
import com.example.lolstats.api.items.converters.Converters

@Database(entities = [Champion::class], version = 1)
@TypeConverters(Converters::class)
abstract class ChampionsDatabase : RoomDatabase() {
    abstract fun championsDao(): ChampionsDao
}