package com.example.lolstats.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.lolstats.api.items.Champion
import kotlinx.coroutines.flow.Flow

@Dao
interface ChampionsDao {
    @Query("SELECT * FROM existing_champions")
    fun getAllChampions(): Flow<List<Champion>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChampions(champions: List<Champion>)

    @Query("DELETE FROM existing_champions")
    suspend fun deleteAllChampions()
}