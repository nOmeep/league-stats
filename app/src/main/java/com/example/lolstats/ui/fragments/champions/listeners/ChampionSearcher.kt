package com.example.lolstats.ui.fragments.champions.listeners

import android.text.Editable
import android.text.TextWatcher

class ChampionSearcher(
    private val block: (CharSequence?) -> Unit
) : TextWatcher {
    override fun beforeTextChanged(query: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(query: CharSequence?, p1: Int, p2: Int, p3: Int) {
        query.let { block.invoke(it) }
    }

    override fun afterTextChanged(query: Editable?) {

    }
}