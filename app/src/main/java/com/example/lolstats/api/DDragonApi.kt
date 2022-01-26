package com.example.lolstats.api

import com.example.lolstats.api.items.GameChampions
import retrofit2.http.GET
import retrofit2.http.Path

interface DDragonApi {
    companion object {
        const val BASE_URL = "http://ddragon.leagueoflegends.com/cdn/12.2.1/"
    }

    @GET("/data/{language}/champion.json")
    fun getAllChampions(@Path("language") language : String) : GameChampions
}