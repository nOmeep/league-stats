package com.example.lolstats.api.items

data class GameChampions (
    val type: String,
    val format: String,
    val version: String,
    val data: Map<String, Champion>
)