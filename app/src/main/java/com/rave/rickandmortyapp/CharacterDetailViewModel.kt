package com.rave.rickandmortyapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rave.rickandmortyapp.data.Repository
import com.rave.rickandmortyapp.models.Character
import kotlinx.coroutines.launch

class CharacterDetailViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private val repo : Repository = Repository
    private val _viewState = MutableLiveData<Character?>()
    val viewState: LiveData<Character?> = _viewState

    private fun getCharacterById(characterId: String){
        viewModelScope.launch {
            _viewState.value = repo.getCharacterById(characterId)

        }
    }
}