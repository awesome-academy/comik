package com.example.comik.data.source.remote.utlis

import com.example.comik.data.model.ComicResponse
import com.example.comik.data.model.CreatorResponse
import com.example.comik.data.model.EventResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface APIService {
    @GET("comics")
    fun getComics(): Observable<ComicResponse>

    @GET("events")
    fun getEvents(): Observable<EventResponse>

    @GET("creators")
    fun getCreators(): Observable<CreatorResponse>
}
