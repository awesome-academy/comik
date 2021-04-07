package com.example.comik.data.repository

import com.example.comik.data.model.Comic
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface ComicRepository {
    fun getFavorites(): Observable<List<Comic>>
    fun insertFavorite(comic: Comic): Completable
    fun deleteFavorite(comic: Comic): Completable
    fun isFavorite(id: String): Single<Boolean>
}
