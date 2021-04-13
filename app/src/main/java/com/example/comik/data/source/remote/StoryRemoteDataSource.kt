package com.example.comik.data.source.remote

import com.example.comik.data.source.StoriesDataSource
import com.example.comik.data.source.remote.utlis.APIService

class StoryRemoteDataSource(
    private val apiService: APIService
) : StoriesDataSource {

    override fun getStories() = apiService.getStories()
}
