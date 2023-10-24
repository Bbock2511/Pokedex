package com.example.pokedex.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.pokedex.databinding.PokemonAdapterBinding
import com.example.pokedex.models.PokemonData
import java.util.Locale

class PokemonAdapter: RecyclerView.Adapter<PokemonAdapter.MyViewHolder>() {

    private var pokemonList = emptyList<PokemonData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonAdapter.MyViewHolder {
        val pokemonItem = PokemonAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(pokemonItem)
    }

    override fun onBindViewHolder(holder: PokemonAdapter.MyViewHolder, position: Int) {
        val currentPokemon = pokemonList[position]
        holder.name.text = currentPokemon.name.toString()
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
            }

        val officialArtWork = currentPokemon.sprites.other.officialArtWork.frontDefault

        Glide.with(holder.itemView.context)
            .load(officialArtWork)
            .into(holder.pokemonImage)

        val singleOrMultiType = currentPokemon.types.size
        val pokemonType1 = currentPokemon.types[0].type.name

        if (singleOrMultiType == 1){
            holder.type1TextView.text = pokemonType1.toString()
                .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            holder.type2TextView.visibility = View.GONE
        } else{
            val pokemonType2 = currentPokemon.types[1].type.name
            holder.type1TextView.text = pokemonType1.toString()
                .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            holder.type2TextView.text = pokemonType2.toString()
                .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        }
    }

    override fun getItemCount() = pokemonList.size

    class MyViewHolder(binding: PokemonAdapterBinding) :RecyclerView.ViewHolder(binding.root) {
        val name = binding.textViewName
        val pokemonImage = binding.imageView
        val type1TextView = binding.typeOneTextView
        val type2TextView = binding.typeTwo
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(pokemon: List<PokemonData>){
        this.pokemonList = pokemon
        notifyDataSetChanged()
    }

}