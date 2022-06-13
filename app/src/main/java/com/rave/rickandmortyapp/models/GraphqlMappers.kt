package com.rave.rickandmortyapp.models

import com.rave.CharacterByIdQuery
import com.rave.CharacterListQuery

fun CharacterListQuery.Character.toCharacter(): Character {
  return Character(
    id,
    name,
    image,
    status,
    species,
    type,
    gender,
    origin = null,
    location = null,
    episode = null,
    created,
  )
}

fun CharacterByIdQuery.Character.toCharacter(): Character {
  return Character(
    id,
    name,
    image,
    status,
    species,
    type,
    gender,
    origin = null,
    location = null,
    episode = null,
    created,
  )
}

fun CharacterListQuery.Result.toCharacter(): Character {
  return Character(
    id,
    name,
    image,
    status,
    species,
    type,
    gender,
    origin?.toLocation(),
    location?.toLocation(),
    episode.map { it?.toEpisode() },
    created,
  )
}

fun CharacterListQuery.Resident1.toCharacter(): Character {
  return Character(
    id,
    name,
    image,
    status,
    species,
    type,
    gender,
    origin = null,
    location = null,
    episode = null,
    created,
  )
}

fun CharacterListQuery.Origin.toLocation(): Location {
  return Location(
    id,
    name,
    type,
    dimension,
    residents.map { it?.toCharacter() }
  )
}

fun CharacterListQuery.Location.toLocation(): Location {
  return Location(
    id,
    name,
    type,
    dimension,
    residents = residents.map { it?.toCharacter() }
  )
}

fun CharacterListQuery.Resident.toCharacter(): Character {
  return Character(
    id,
    name,
    image,
    status,
    species,
    type,
    gender,
    origin = null,
    location = null,
    episode = null,
    created,
  )
}

fun CharacterListQuery.Episode.toEpisode(): Episode {
  return Episode(
    id,
    name,
    air_date,
    episode,
    characters.map { it?.toCharacter() },
    created,
  )
}
