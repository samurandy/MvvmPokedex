package com.example.mvvmpokedex.model

import com.google.gson.annotations.SerializedName

data class PokemonResponse (
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String,
    @SerializedName("previous") val previous: String,
    @SerializedName("results") val results: List<PokemonResult>
)
data class PokemonResult(
    @SerializedName("name") val name: String,
    @SerializedName("url"  ) var url  : String
)

