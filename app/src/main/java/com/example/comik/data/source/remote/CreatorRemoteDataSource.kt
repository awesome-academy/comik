package com.example.comik.data.source.remote

import com.example.comik.data.source.CreatorsDataSource
import com.example.comik.data.source.remote.utlis.APIService

class CreatorRemoteDataSource(
    private val apiService: APIService
) : CreatorsDataSource {

    override fun getCreators() = apiService.getCreators()
}
