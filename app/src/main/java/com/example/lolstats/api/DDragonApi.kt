package com.example.lolstats.api

import com.example.lolstats.api.items.GameChampions
import com.example.lolstats.api.items.Image
import retrofit2.http.GET
import retrofit2.http.Path

interface DDragonApi {
    companion object {
        const val BASE_URL = "https://ddragon.leagueoflegends.com/cdn/12.2.1/"
    }

    @GET("data/{language}/champion.json")
    suspend fun getAllChampions(
        @Path("language") language: String
    ): GameChampions

    @GET("img/champion/{heroName}.png")
    suspend fun getSquareAsset(
        @Path("heroName") hero : String
    ) : String
}