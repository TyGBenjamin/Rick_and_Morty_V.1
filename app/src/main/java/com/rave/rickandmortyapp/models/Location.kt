package com.rave.rickandmortyapp.models

data class Location(
    val id: String?,
    val name: String?,
    val type: String?,
    val dimension: String?,
    val residents: List<Character?>,
)
