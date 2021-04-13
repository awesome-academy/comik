package com.example.comik.data.source.remote

import com.example.comik.data.source.CharactersDataSource
import com.example.comik.data.source.remote.utlis.APIService

class CharacterRemoteDataSource(
    private val apiService: APIService
) : CharactersDataSource {

    override fun getCharacters() = apiService.getCharacters()
}
