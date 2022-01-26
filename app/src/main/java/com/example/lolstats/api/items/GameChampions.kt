package com.example.lolstats.api.items

data class GameChampions(
    val type : String,
    val version: String,
    val data : List<Champion>
) {
    data class Champion(
        val version: String,
        val id : String,
        val key : String,
        val name : String
    )
}