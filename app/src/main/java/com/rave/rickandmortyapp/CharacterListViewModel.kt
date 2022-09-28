package com.rave.rickandmortyapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rave.CharacterListQuery
import com.rave.rickandmortyapp.data.Repository
import com.rave.rickandmortyapp.data.Resource
import com.rave.rickandmortyapp.models.Character
import kotlinx.coroutines.launch

class CharacterViewModel: ViewModel() {
    private val repo :Repository = Repository
    private val _viewState = MutableLiveData<List<Character?>?>()
    val viewState: LiveData<List<Character?>?> = _viewState

    init {
        getCharacter()

    }
    private fun getCharacter(){
        viewModelScope.launch {
            _viewState.value = repo.getCharacterList(null,  null)

        }
    }



}


