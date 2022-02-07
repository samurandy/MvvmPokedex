package com.example.mvvmpokedex.view

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.mvvmpokedex.databinding.ActivityDetailBinding
import com.example.mvvmpokedex.model.PokemonProvider
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private var provider = PokemonProvider()
    lateinit var pokemonSprite: Bitmap



    companion object {
        const val EXTRA_ID =
            "position" //Better use "const" to improve performance (see Antonio Leiva video)
        const val IMAGE_BASE_URL =
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        fillPokemonDetail()

    }


    private fun fillPokemonDetail() {
        val position = intent.getIntExtra(EXTRA_ID, -1)
        lifecycleScope.launch {
            with(provider.getPokemon(position + 1)) {
                with(binding) {
                    nameDetail.text = name
                    heightDetail.text = "${(height/10)}m"
                    weightDetail.text = "${(weight/10)}kg"
                    Glide.with(this@DetailActivity).load("$IMAGE_BASE_URL${position + 1}.png")
                        .into(imagePokemonDetail)
                }
            }
        }
    }

    /*private fun getProminentColor(): Color{
        Palette.Builder(Bitmap.createBitmap(DrawableRes ))
        Bitmap.
    }*/
}