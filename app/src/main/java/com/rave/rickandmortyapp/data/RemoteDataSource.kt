package com.rave.rickandmortyapp.data

import com.apollographql.apollo3.ApolloClient

object RemoteDataSource {
  val apolloClient = ApolloClient.Builder()
    .serverUrl("https://rickandmortyapi.com/graphql")
    .build()
}