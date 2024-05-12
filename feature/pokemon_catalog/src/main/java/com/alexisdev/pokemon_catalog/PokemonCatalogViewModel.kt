package com.alexisdev.pokemon_catalog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.alexisdev.domain.FetchPokemonListUseCase
import com.alexisdev.model.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class PokemonCatalogViewModel(
    private val fetchPokemonListUseCase: FetchPokemonListUseCase
) : ViewModel() {
    private val _pokemons = MutableLiveData<PagingData<Pokemon>>()
    val pokemons: LiveData<PagingData<Pokemon>> get() = _pokemons

    init {
        fetchPokemonList()
    }

    private fun fetchPokemonList() = viewModelScope.launch(Dispatchers.IO) {
        fetchPokemonListUseCase.invoke()
            .cachedIn(viewModelScope)
            .collect { pagingData ->
                _pokemons.postValue(pagingData)
            }
    }
}