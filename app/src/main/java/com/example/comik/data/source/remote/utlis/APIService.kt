package com.example.comik.data.source.remote.utlis

import com.example.comik.data.model.*
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("comics")
    fun getComics(): Observable<ComicResponse>

    @GET("events")
    fun getEvents(): Observable<EventResponse>

    @GET("creators")
    fun getCreators(): Observable<CreatorResponse>

    @GET("comics")
    fun getComicsByYear(
        @Query("format") format: String,
        @Query("startYear") year: Int
    ): Observable<ComicResponse>

    @GET("characters")
    fun getCharacters(): Observable<CharacterResponse>

    @GET("series")
    fun getSeries(): Observable<SeriesResponse>

    @GET("stories")
    fun getStories(): Observable<StoryResponse>
}
