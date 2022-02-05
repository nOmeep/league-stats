package com.example.lolstats.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.lolstats.db.ChampionsRepository
import com.example.lolstats.util.Languages
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LeagueStatsViewModel @Inject constructor(
    private val repository: ChampionsRepository
) : ViewModel() {
    val championsListLiveData = repository.getAllChampions(Languages.ENGLISH).asLiveData()

    /*
    init {
        viewModelScope.launch {
            val championsMap = dragonApi.getAllChampions(Languages.ENGLISH).data
            championsListLiveData.value = championsMap.values.toList()
        }
    }

    fun getAllExistingChampions() = championsListLiveData

     */
}