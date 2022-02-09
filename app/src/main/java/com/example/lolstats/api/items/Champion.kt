package com.example.lolstats.api.items

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "existing_champions")
data class Champion(
    val blurb: String,
    @PrimaryKey(autoGenerate = false)
    val id: String,
    @Embedded val image: Image,
    @Embedded val info: Info,
    val key: String,
    val name: String,
    val partype: String,
    @Embedded val stats: Stats,
    val tags: List<String>,
    val title: String,
    val version: String
)