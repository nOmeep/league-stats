package com.example.lolstats.db

import androidx.room.withTransaction
import com.example.lolstats.api.DDragonApi
import com.example.lolstats.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class ChampionsRepository @Inject constructor(
    private val api: DDragonApi,
    private val db: ChampionsDatabase
) {
    private val championsDao = db.championsDao()

    fun getAllChampions(language: String) = networkBoundResource(
        query = {
            championsDao.getAllChampions()
        },
        fetch = {
            delay(2000)
            api.getAllChampions(language)
        },
        saveFetchResult = { champions ->
            db.withTransaction {
                championsDao.deleteAllChampions()
                championsDao.insertChampions(champions.data.values.toList())
            }
        }
    )
}