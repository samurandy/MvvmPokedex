package com.example.mvvmpokedex.model

class PokemonProvider {
    companion object {

        fun getPokemonList(): List<PokemonModel>{
            return pokemonList
        }

        private val pokemonList = listOf(
            PokemonModel("Pikachu",1.5, 4.0, "http://pokemonImages.com/1.jpg"),
            PokemonModel("Bulbasaur",1.2, 5.0, "http://pokemonImages.com/2.jpg"),
            PokemonModel("Squirtle",0.8, 3.2, "http://pokemonImages.com/3.jpg"),
            PokemonModel("JigglyPuff",0.6, 2.7, "http://pokemonImages.com/4.jpg"),
            PokemonModel("Charmander",1.1, 3.1,"http://pokemonImages.com/5.jpg")
        )
    }
}