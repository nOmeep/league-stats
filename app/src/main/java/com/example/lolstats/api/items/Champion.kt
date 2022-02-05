package com.example.lolstats.api.items

import androidx.room.Entity

@Entity(tableName = "existing_champions")
data class Champion(
    val blurb: String,
    val id: String,
    val image: Image,
    val info: Info,
    val key: String,
    val name: String,
    val partype: String,
    val stats: Stats,
    val tags: List<String>,
    val title: String,
    val version: String
)