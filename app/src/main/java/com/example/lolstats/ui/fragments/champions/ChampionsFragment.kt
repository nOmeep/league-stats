package com.example.lolstats.ui.fragments.champions

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.lolstats.R
import com.example.lolstats.databinding.FragmentChampionsBinding
import com.example.lolstats.ui.fragments.champions.listeners.ChampionSearcher
import com.example.lolstats.ui.fragments.champions.listeners.OnChangeScroller
import com.example.lolstats.ui.viewmodel.LeagueStatsViewModel
import com.example.lolstats.util.cache.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChampionsFragment : Fragment(R.layout.fragment_champions) {
    private val viewModel by viewModels<LeagueStatsViewModel>()

    private var _binding: FragmentChampionsBinding? = null
    private val binding
        get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentChampionsBinding.bind(view)

        val championsAdapter = ChampionsAdapter()
        binding.rvChampionList.adapter = championsAdapter

        binding.rvChampionList.adapter?.registerAdapterDataObserver(OnChangeScroller(binding.rvChampionList))

        binding.etSearchChampion.addTextChangedListener(ChampionSearcher {
            championsAdapter.filter(it)
        })

        viewModel.getAllExistingChampions().observe(viewLifecycleOwner) { resource ->
            championsAdapter.modifyList(resource.data)
            resource.setLoadingOrError(binding)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}