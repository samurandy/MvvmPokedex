package com.example.mvvmpokedex.network

import com.example.mvvmpokedex.model.PokemonModel
import com.example.mvvmpokedex.model.PokemonResponse
import com.example.mvvmpokedex.model.PokemonResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class PokemonService {


    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getAllPokemon(): List<PokemonResult> {
        return withContext(Dispatchers.IO) {
            val response: Response<PokemonResponse> =
                retrofit.create(PokemonApiClient::class.java).getAllPokemon()
            response.body()?.results ?: emptyList()
        }

    }

    suspend fun getPokemon(id: Int): PokemonModel {
        return withContext(Dispatchers.IO) {
            val response: Response<PokemonModel> =
                retrofit.create(PokemonApiClient::class.java).getPokemon(id)
            response.body() ?: PokemonModel("", 0.0, 0.0, "")
        }
    }
}