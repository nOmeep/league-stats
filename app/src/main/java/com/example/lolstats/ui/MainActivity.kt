package com.example.lolstats.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.lolstats.R
import com.example.lolstats.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_main)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.championsFragment,
                R.id.tierListFragment,
                R.id.profileStatsFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.bnvBottomBar.setupWithNavController(navController)
    }
}