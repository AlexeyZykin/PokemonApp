package com.alexisdev.pokemon_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexisdev.common.Response
import com.alexisdev.domain.FetchPokemonDetailsUseCase
import com.alexisdev.model.PokemonDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class PokemonDetailsViewModel(
    private val fetchPokemonDetailsUseCase: FetchPokemonDetailsUseCase
) : ViewModel() {
    private val _state = MutableLiveData<PokemonDetailsState<PokemonDetails>>()
    val state: LiveData<PokemonDetailsState<PokemonDetails>> get() = _state

    fun fetchPokemonDetails(pokemonName: String) = viewModelScope.launch(Dispatchers.IO) {
        fetchPokemonDetailsUseCase.invoke(pokemonName).distinctUntilChanged().collect { response ->
            when (response) {
                is Response.Loading -> _state.postValue(PokemonDetailsState.Loading())

                is Response.Success -> if (response.data != null) {
                    _state.postValue(PokemonDetailsState.Success(response.data))
                }

                is Response.Error -> _state.postValue(PokemonDetailsState.Error(response.msg))
            }
        }
    }
}