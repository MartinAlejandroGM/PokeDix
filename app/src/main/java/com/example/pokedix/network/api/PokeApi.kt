package com.example.pokedix.network.api

import com.example.pokedix.models.*
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApi {
    @GET("v2/pokemon")
    suspend fun getPokemonList(): PokedexListResponse

    @GET("v2/pokedex/{region}/")
    suspend fun getPokedex(@Path("region") region: String): PokedexListResponse

    @GET("v2/version-group")
    suspend fun getGamesList(): GameListResponse

    @GET("{url}")
    suspend fun getPokedexesByGroupVersion(@Path("url") url: String): GameResponse

    @GET("v2/pokemon/{pokeName}/")
    suspend fun getPokemon(@Path("pokeName") pokeName: String): PokemonDetailsResponse

    @GET("v2/pokemon-species/{pokeName}/")
    suspend fun getPokeSpecies(@Path("pokeName") pokeName: String): PokemonSpecieResponse
}