package com.example.comik.data.repository

import com.example.comik.data.model.Comic
import com.example.comik.data.source.ComicDataSource
import io.reactivex.rxjava3.core.Observable

class ComicRepositoryImpl(
    private val local: ComicDataSource.Local,
    private val remote: ComicDataSource.Remote
) : ComicRepository {

    override fun getFavorites() = local.getFavorites()

    override fun insertFavorite(comic: Comic) = local.insertFavorite(comic)

    override fun deleteFavorite(comic: Comic) = local.deleteFavorite(comic)

    override fun isFavorite(id: String) = local.isFavorite(id)

    override fun getComics(): Observable<List<Comic>> = remote.getComics().map { it.data.results }

    override fun getComicByYear(format: String, year: Int): Observable<List<Comic>> =
        remote.getComicsByYear(format, year).map { it.data.results }
}
