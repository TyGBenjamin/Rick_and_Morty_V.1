package com.rave.rickandmortyapp.models.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rave.rickandmortyapp.data.Repository
import com.rave.rickandmortyapp.models.Character
import kotlinx.coroutines.launch

class DashboardViewModel: ViewModel() {
    private val repo = Repository
    private var _characters: MutableLiveData<List<Character>> = MutableLiveData()
    private var page = 1
    var characters: LiveData<List<Character>> = _characters

    init {
        updateChars()
    }

    fun nextPage() {
        page++
        updateChars()
    }

    fun prevPage() {
        if(page > 1) page--
        updateChars()
    }

    private fun updateChars() {
        viewModelScope.launch {
            _characters.value = repo.getCharacterList(page, filterCharacter = null) as List<Character>?
        }
    }

}