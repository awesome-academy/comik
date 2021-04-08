package com.example.comik.data.source.remote

import com.example.comik.data.source.ComicDataSource
import com.example.comik.data.source.remote.utlis.APIService

class ComicRemoteDataSource(
    private val apiService: APIService
) : ComicDataSource.Remote {

    override fun getComics() = apiService.getComics()
}
