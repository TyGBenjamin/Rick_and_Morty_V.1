package com.rave.rickandmortyapp.models

data class Episode(
    val id: String?,
    val name: String?,
    val air_date: String?,
    val episode: String?,
    val characters: List<Character?>,
    val created: String?,
)
