package com.example.mvvmpokedex.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmpokedex.databinding.ActivityMainBinding
import com.example.mvvmpokedex.model.PokemonProvider
import com.example.mvvmpokedex.model.PokemonResult


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var pokemonList: List<PokemonResult>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerPokemon.layoutManager = LinearLayoutManager(this)
        loadPokemonInAdapter()

    }

    private fun loadPokemonInAdapter() {
        lifecycleScope.launch {
            pokemonList = PokemonProvider().getPokemon()
            binding.recyclerPokemon.adapter = AdapterRecycler(pokemonList)
        }
    }
}