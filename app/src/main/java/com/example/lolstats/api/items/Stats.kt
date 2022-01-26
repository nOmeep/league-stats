package com.example.lolstats.api.items

data class Stats(
    val armor: Float,
    val armorperlevel: Double,
    val attackdamage: Float,
    val attackdamageperlevel: Float,
    val attackrange: Float,
    val attackspeed: Double,
    val attackspeedperlevel: Double,
    val crit: Float,
    val critperlevel: Float,
    val hp: Float,
    val hpperlevel: Float,
    val hpregen: Float,
    val hpregenperlevel: Float,
    val movespeed: Float,
    val mp: Float,
    val mpperlevel: Float,
    val mpregen: Float,
    val mpregenperlevel: Float,
    val spellblock: Float,
    val spellblockperlevel: Double
)