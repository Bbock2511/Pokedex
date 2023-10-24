package com.example.pokedex.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.models.PokemonData
import com.example.pokedex.repository.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private const val MIN_POKEMON_ID = 1
private const val MAX_POKEMON_ID = 151

class PokedexViewModel : ViewModel() {

    private val repository = PokemonRepository()
    private val _pokemon = MutableLiveData<List<PokemonData>>()
    val pokemon: LiveData<List<PokemonData>>
        get() = _pokemon

    fun getPokemon() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = mutableListOf<PokemonData>()

            for (i in MIN_POKEMON_ID..MAX_POKEMON_ID){
                data.add(repository.getPokemon(i))
            }

            withContext(Dispatchers.Main) {
                _pokemon.postValue(data.toList())
            }
        }
    }
}