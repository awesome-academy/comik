package com.example.comik.data.source.remote

import com.example.comik.data.source.ComicsDataSource
import com.example.comik.data.source.remote.utlis.APIService

class ComicRemoteDataSource(
    private val apiService: APIService
) : ComicsDataSource.Remote {

    override fun getComics() = apiService.getComics()

    override fun getComicsByYear(format: String, year: Int) =
        apiService.getComicsByYear(format, year)

    override fun getComicsByCharacter(characterId: Int) =
        apiService.getComicsByCharacter(characterId)

    override fun getComicsByEvent(eventId: Int) = apiService.getComicsByEvent(eventId)

    override fun getComicsBySeries(seriesId: Int) = apiService.getComicsBySeries(seriesId)

    override fun getComicsByStory(storyId: Int) = apiService.getComicsByStory(storyId)

    override fun getComicsByCreator(creatorId: Int) = apiService.getComicsByCreators(creatorId)
}
