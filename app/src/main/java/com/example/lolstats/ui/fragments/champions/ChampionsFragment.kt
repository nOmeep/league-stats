package com.example.lolstats.ui.fragments.champions

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.lolstats.R
import com.example.lolstats.databinding.FragmentChampionsBinding
import com.example.lolstats.ui.viewmodel.LeagueStatsViewModel
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

        binding.apply {
            rvChampionList.adapter = championsAdapter
            setTopScrollAfterChange()
            setSearchFunctionality()
        }

        viewModel.championList.observe(viewLifecycleOwner) { champions ->
            championsAdapter.modifyList(champions)
        }
    }

    private fun setTopScrollAfterChange() {
        binding.apply {
            rvChampionList.adapter?.registerAdapterDataObserver(object :
                RecyclerView.AdapterDataObserver() {
                override fun onChanged() {
                    rvChampionList.scrollToPosition(0)
                }

                override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
                    rvChampionList.scrollToPosition(0)
                }

                override fun onItemRangeMoved(fromPosition: Int, toPosition: Int, itemCount: Int) {
                    rvChampionList.scrollToPosition(0)
                }

                override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                    rvChampionList.scrollToPosition(0)
                }

                override fun onItemRangeChanged(positionStart: Int, itemCount: Int) {
                    rvChampionList.scrollToPosition(0)
                }

                override fun onItemRangeChanged(positionStart: Int, itemCount: Int, payload: Any?) {
                    rvChampionList.scrollToPosition(0)
                }
            })
        }
    }

    private fun setSearchFunctionality() {
        binding.apply {
            svFindChampions.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?) = false

                override fun onQueryTextChange(newText: String?): Boolean {
                    (rvChampionList.adapter as ChampionsAdapter).filter(newText)
                    return true
                }
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}