package com.example.comik.data.repository

import com.example.comik.data.model.Comic
import com.example.comik.data.source.ComicsDataSource
import com.example.comik.utils.BUNDLE.BUNDLE_CHARACTER
import com.example.comik.utils.BUNDLE.BUNDLE_CREATOR
import com.example.comik.utils.BUNDLE.BUNDLE_EVENT
import com.example.comik.utils.BUNDLE.BUNDLE_SERIES
import io.reactivex.rxjava3.core.Observable

class ComicRepositoryImpl(
    private val local: ComicsDataSource.Local,
    private val remote: ComicsDataSource.Remote
) : ComicRepository {

    override fun getFavorites() = local.getFavorites()

    override fun insertFavorite(comic: Comic) = local.insertFavorite(comic)

    override fun deleteFavorite(comic: Comic) = local.deleteFavorite(comic)

    override fun isFavorite(id: Int) = local.isFavorite(id)

    override fun getComics(): Observable<List<Comic>> = remote.getComics().map { it.data.results }

    override fun getComicByYear(format: String, year: Int): Observable<List<Comic>> =
        remote.getComicsByYear(format, year).map { it.data.results }

    override fun getComicsByType(type: String, id: Int): Observable<List<Comic>> =
        when (type) {
            BUNDLE_CHARACTER -> remote.getComicsByCharacter(id)
            BUNDLE_SERIES -> remote.getComicsBySeries(id)
            BUNDLE_EVENT -> remote.getComicsByEvent(id)
            BUNDLE_CREATOR -> remote.getComicsByCreator(id)
            else -> remote.getComicsByStory(id)
        }.map { it.data.results }

    override fun getComic(comicId: Int): Observable<Comic> =
        remote.getComic(comicId).map { it.data.results.first() }
}
