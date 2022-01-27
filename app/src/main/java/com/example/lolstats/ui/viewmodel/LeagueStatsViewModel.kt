package com.example.lolstats.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lolstats.api.DDragonApi
import com.example.lolstats.api.items.Champion
import com.example.lolstats.util.Languages
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LeagueStatsViewModel @Inject constructor(
    private val dragonApi: DDragonApi
) : ViewModel() {
    private val championsListLiveData = MutableLiveData<List<Champion>>()
    val championList: LiveData<List<Champion>> = championsListLiveData

    init {
        viewModelScope.launch {
            val championsMap = dragonApi.getAllChampions(Languages.ENGLISH).data
            val listOfChampions = mutableListOf<Champion>()
            for (item in championsMap) {
                listOfChampions.add(item.value)
            }
            championsListLiveData.value = listOfChampions
        }
    }
}