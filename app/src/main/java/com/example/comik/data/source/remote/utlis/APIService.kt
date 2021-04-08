package com.example.comik.data.source.remote.utlis

import com.example.comik.data.model.ComicResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface APIService {
    @GET("comics")
    fun getComics(): Observable<ComicResponse>
}
