package com.example.mvvmpokedex.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmpokedex.databinding.ActivityMainBinding
import com.example.mvvmpokedex.model.PokemonModel
import com.example.mvvmpokedex.model.PokemonProvider



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var pokemonList: List<PokemonModel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pokemonList = PokemonProvider.getPokemonList()
        binding.recyclerPokemon.adapter = AdapterRecycler(pokemonList)
        binding.recyclerPokemon.layoutManager = LinearLayoutManager(this)

    }
}