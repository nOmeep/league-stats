package com.example.lolstats.api.items.converters

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromStats(stats: List<String>): String {
        return stats.joinToString(",")
    }

    @TypeConverter
    fun toStats(data: String): List<String> {
        return data.split(",")
    }
}