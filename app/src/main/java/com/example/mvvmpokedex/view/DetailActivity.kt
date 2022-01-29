package com.example.mvvmpokedex.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmpokedex.databinding.ActivityDetailBinding
import com.example.mvvmpokedex.model.PokemonProvider

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    val pokemonList = PokemonProvider.getPokemonList()

    companion object {
        const val EXTRA_ID = "position" //Better use "const" to improve performance (see Antonio Leiva video)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fillPokemonDetail()
    }


    private fun fillPokemonDetail(){
        val position = intent.getIntExtra(EXTRA_ID, -1)
        with(pokemonList[position]){
            binding.nameDetail.text = name
            binding.heightDetail.text = height.toString()
            binding.weightDetail.text = weight.toString()
        }
    }
}