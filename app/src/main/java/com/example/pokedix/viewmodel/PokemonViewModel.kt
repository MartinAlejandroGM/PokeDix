package com.example.pokedix.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pokedix.models.PokemonResponse
import com.example.pokedix.models.Results
import com.example.pokedix.repository.impl.PokemonRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonViewModel(application: Application) : AndroidViewModel(application) {
    private val pokemonRepository = PokemonRepositoryImpl()
    private val _pokemonLiveData: MutableLiveData<List<Results>> = MutableLiveData()

    val pokemonLiveData: LiveData<List<Results>>
        get() = _pokemonLiveData

    fun fetchPokemon() {
        viewModelScope.launch(Dispatchers.IO) {
            _pokemonLiveData.postValue(pokemonRepository.getPokemons())
        }
    }
}