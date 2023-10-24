package com.example.pokedex

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.adapter.PokemonAdapter
import com.example.pokedex.databinding.ActivityMainBinding
import com.example.pokedex.viewmodel.PokedexViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pokedexViewModel: PokedexViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = PokemonAdapter()
        val recyclerView = binding.pokemonRecyclerView

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.setHasFixedSize(true)

        pokedexViewModel = ViewModelProvider(this)[PokedexViewModel::class.java]

        pokedexViewModel.getPokemon()

        pokedexViewModel.pokemon.observe(this@MainActivity) { pokedex ->
            adapter.setData(pokedex)
            pokedex.forEach { pokemon ->
                Log.i("Pokemon", "$pokemon")
            }
        }
    }
}