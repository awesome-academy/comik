package com.example.comik.data.source.remote

import com.example.comik.data.source.SeriesDataSource
import com.example.comik.data.source.remote.utlis.APIService

class SeriesRemoteDataSource(
    private val apiService: APIService
) : SeriesDataSource {

    override fun getSeries() = apiService.getSeries()
}
