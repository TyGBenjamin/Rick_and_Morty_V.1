package com.rave.rickandmortyapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rave.rickandmortyapp.data.RemoteDataSource
import com.rave.rickandmortyapp.data.Repository
import  com.rave.rickandmortyapp.models.Character
import kotlinx.coroutines.launch

class ViewModel: ViewModel(){
    private val repo: Repository = Repository
    private val _viewState = MutableLiveData<List<Character?>?>()
    val viewState:LiveData<List<Character?>?> = _viewState

    init {
        getCharcater()
    }

    private fun getCharcater(){
        viewModelScope.launch {
            _viewState.value = repo.getCharacterList(null, null)
        }
    }

}