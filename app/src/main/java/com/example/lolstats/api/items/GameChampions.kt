package com.example.lolstats.api.items

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameChampions(
    val type: String,
    val version: String,
    val data: Map<String, Champion>
) : Parcelable {
    @Parcelize
    data class Champion(
        val version: String,
        val id: String,
        val key: String,
        val name: String,
        val title: String
    ) : Parcelable
}