package com.example.lolstats.util

fun String.toChampionNameUrl() : String {
    return when(this) {
        "Kai'Sa" -> "Kaisa"
        "Kog'Maw" -> "KogMaw"
        "LeBlanc" -> "Leblanc"
        "Cho'Gath" -> "Chogath"
        "Kha'Zix" -> "Khazix"
        "Wukong" -> "MonkeyKing"
        "Vel'Koz" -> "Velkoz"
        "Rek'Sai" -> "RekSai"
        else -> this.split("&")[0].replace("[\\s.]".toRegex(), "")
    }
}