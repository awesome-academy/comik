package com.example.comik.data.source.remote

import com.example.comik.data.source.ComicsDataSource
import com.example.comik.data.source.remote.utlis.APIService

class ComicRemoteDataSource(
    private val apiService: APIService
) : ComicsDataSource.Remote {

    override fun getComics() = apiService.getComics()

    override fun getComicsByYear(format: String, year: Int) =
        apiService.getComicsByYear(format, year)
}
