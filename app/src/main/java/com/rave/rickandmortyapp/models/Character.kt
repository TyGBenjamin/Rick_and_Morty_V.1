package com.rave.rickandmortyapp.models

data class Character(
    val id: String?,
    val name: String?,
    val image: String?,
    val status: String?,
    val species: String?,
    val type: String?,
    val gender: String?,
    val origin: Location?,
    val location: Location?,
    val episode: List<Episode?>?,
    val created: String?,
)
