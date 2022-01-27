package com.example.lolstats.ui.fragments.champions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lolstats.api.items.Champion
import com.example.lolstats.databinding.ItemChampionCircleBinding

class ChampionsAdapter :
    ListAdapter<Champion, ChampionsAdapter.ChampionViewHolder>(ChampionComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChampionViewHolder {
        val binding =
            ItemChampionCircleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChampionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChampionViewHolder, position: Int) {
        val currentChampion = getItem(position)
        if (currentChampion != null) {
            holder.bind(currentChampion)
        }
    }

    inner class ChampionViewHolder(
        private val binding: ItemChampionCircleBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(champion: Champion) {
            binding.apply {
                tvChampionName.text = champion.name

                Glide.with(itemView)
                    .load("https://ddragon.leagueoflegends.com/cdn/12.2.1/img/champion/${champion.image.full}")
                    .into(civChampionCircle)
            }
        }
    }

    class ChampionComparator : DiffUtil.ItemCallback<Champion>() {
        override fun areItemsTheSame(oldItem: Champion, newItem: Champion) =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Champion, newItem: Champion) =
            oldItem == newItem

    }
}