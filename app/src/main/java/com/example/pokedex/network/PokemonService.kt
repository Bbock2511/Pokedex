package com.example.pokedex.network

import com.example.pokedex.models.PokemonData
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    @GET("pokemon/{id}/")
    suspend fun getPokemon(
        @Path("id") id: Int?
    ): PokemonData
}