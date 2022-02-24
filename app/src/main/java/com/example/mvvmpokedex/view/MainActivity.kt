package com.example.mvvmpokedex.view

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.launch
import com.example.mvvmpokedex.databinding.ActivityMainBinding
import com.example.mvvmpokedex.model.PokemonProvider
import com.example.mvvmpokedex.model.PokemonResult
import kotlinx.coroutines.delay


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var pokemonList: List<PokemonResult>
    private var provider = PokemonProvider()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerPokemon.layoutManager = GridLayoutManager(this,2)
        loadPokemonInAdapter()

    }

    private fun loadPokemonInAdapter() {
        lifecycleScope.launch {
            if (isNetworkAvailable(applicationContext)) {

                pokemonList = provider.getAllPokemon()
                binding.recyclerPokemon.adapter = AdapterRecycler(pokemonList)

            } else {
                toast("No connection available")
                delay(2000).also { finish() }
            }
        }
    }

    private fun isNetworkAvailable(context: Context) =
        (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).run {
            getNetworkCapabilities(activeNetwork)?.run {
                hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                        || hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                        || hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
            } ?: false
        }
}

//Extension function
fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}