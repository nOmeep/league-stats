package com.example.lolstats.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.lolstats.db.ChampionsRepository
import com.example.lolstats.util.Languages
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LeagueStatsViewModel @Inject constructor(
    repository: ChampionsRepository,
) : ViewModel() {
    private val championsListLiveData = repository.getAllChampions(Languages.ENGLISH).asLiveData()

    fun getAllExistingChampions() = championsListLiveData
}