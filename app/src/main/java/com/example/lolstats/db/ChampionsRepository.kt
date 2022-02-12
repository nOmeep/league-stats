package com.example.lolstats.db

import androidx.room.withTransaction
import com.example.lolstats.api.DDragonApi
import com.example.lolstats.util.cache.networkBoundResource
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