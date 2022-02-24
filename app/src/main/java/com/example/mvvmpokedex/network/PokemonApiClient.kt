package com.example.mvvmpokedex.network

import com.example.mvvmpokedex.model.PokemonModel
import com.example.mvvmpokedex.model.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokemonApiClient {
    companion object {
        const val POKEMON_LIMIT = 100
        const val POKEMON_OFFSET = 0
    }

    @GET("pokemon")
    suspend fun getAllPokemon(
        @Query("limit") limit: Int = POKEMON_LIMIT,
        @Query("offset") offset: Int = POKEMON_OFFSET
    ): Response<PokemonResponse>


    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") id: Int): Response<PokemonModel>

}