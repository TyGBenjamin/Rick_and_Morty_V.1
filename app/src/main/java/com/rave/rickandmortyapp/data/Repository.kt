package com.rave.rickandmortyapp.data

import com.rave.CharacterByIdQuery
import com.rave.CharacterListQuery
import com.rave.rickandmortyapp.models.Character
import com.rave.rickandmortyapp.models.toCharacter
import com.rave.type.FilterCharacter

class Repository {
  private val apolloClient = RemoteDataSource.apolloClient

  suspend fun getCharacterList(
    page: Int?,
    filterCharacter: FilterCharacter?,
  ): List<Character?>? {
    val result =
      apolloClient.query(CharacterListQuery(page, filterCharacter)).execute()

    return result.data?.characters?.results?.map { it?.toCharacter() }
  }

  suspend fun getCharacterById(
    id: String,
  ): Character? {
    val result =
      apolloClient.query(CharacterByIdQuery(id)).execute()

    return result.data?.character?.toCharacter()
  }
}