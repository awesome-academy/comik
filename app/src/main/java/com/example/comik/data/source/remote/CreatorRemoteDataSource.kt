package com.example.comik.data.source.remote

import com.example.comik.data.source.CreatorDataSource
import com.example.comik.data.source.remote.utlis.APIService

class CreatorRemoteDataSource(
    private val apiService: APIService
) : CreatorDataSource {

    override fun getCreators() = apiService.getCreators()
}
