package com.example.mvvmpokedex.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmpokedex.databinding.ItemCardBinding
import com.example.mvvmpokedex.model.PokemonResult

class AdapterRecycler(private var pokemonList: List<PokemonResult>) :
    RecyclerView.Adapter<AdapterRecycler.ViewHolder>() {

    inner class ViewHolder(val binding:ItemCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //fill recyclerview
        with(holder){
            with (pokemonList[position]){
                binding.name.text = "#${position+1} $name"
            }
        }

        //ClickListener in recycler from Main to Detail
        holder.binding.itemCard.setOnClickListener { v ->
            val intent = Intent(v.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_ID, position)
            v.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }
}