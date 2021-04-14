package com.example.comik.data.source

import com.example.comik.data.model.Comic
import com.example.comik.data.model.ComicResponse
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface ComicsDataSource {
    interface Local {
        fun getFavorites(): Observable<List<Comic>>
        fun insertFavorite(comic: Comic): Completable
        fun deleteFavorite(comic: Comic): Completable
        fun isFavorite(id: Int): Single<Boolean>
    }

    interface Remote {
        fun getComics(): Observable<ComicResponse>
        fun getComicsByYear(format: String, year: Int): Observable<ComicResponse>
        fun getComicsByCharacter(characterId: Int): Observable<ComicResponse>
        fun getComicsByEvent(eventId: Int): Observable<ComicResponse>
        fun getComicsBySeries(seriesId: Int): Observable<ComicResponse>
        fun getComicsByStory(storyId: Int): Observable<ComicResponse>
        fun getComicsByCreator(creatorId: Int): Observable<ComicResponse>
        fun getComic(comicId: Int): Observable<ComicResponse>
    }
}
