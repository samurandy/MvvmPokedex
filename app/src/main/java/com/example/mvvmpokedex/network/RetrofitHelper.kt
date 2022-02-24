package com.example.mvvmpokedex.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/docs/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}