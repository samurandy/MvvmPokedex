package com.example.mvvmpokedex.view

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmpokedex.databinding.ActivityMainBinding
import com.example.mvvmpokedex.model.PokemonProvider
import com.example.mvvmpokedex.model.PokemonResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext


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
            if (isNetworkAvailable(applicationContext)) {

                pokemonList = PokemonProvider().getPokemon()
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