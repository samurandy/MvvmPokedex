package com.example.mvvmpokedex.model

import com.example.mvvmpokedex.network.PokemonService

class PokemonProvider {
    private val pokemonService = PokemonService()

    suspend fun getAllPokemon(): List<PokemonResult> {
        return pokemonService.getAllPokemon()
    }

    suspend fun getPokemon(id: Int): PokemonModel{
        return pokemonService.getPokemon(id)
    }
}