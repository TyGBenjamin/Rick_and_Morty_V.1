package com.rave.rickandmortyapp.models.characterDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rave.rickandmortyapp.data.Repository
import com.rave.rickandmortyapp.models.Character
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CharacterDetailsViewModel: ViewModel() {
    private val repo = Repository
    private val _char = MutableStateFlow<Character?>(null)
    val char = _char.asStateFlow()

    fun populateCharacter(charId: String) {
        viewModelScope.launch {
            _char.value = repo.getCharacterById(charId)
        }
    }
}