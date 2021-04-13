package com.example.comik.data.source.local

import com.example.comik.data.model.Comic
import com.example.comik.data.source.ComicsDataSource
import com.example.comik.data.source.local.database.dao.ComicDao
import io.reactivex.rxjava3.core.Single

class ComicLocalDataSource(
    private val comicDao: ComicDao
) : ComicsDataSource.Local {

    override fun getFavorites() = comicDao.getFavorites()

    override fun insertFavorite(comic: Comic) = comicDao.insertFavorite(comic)

    override fun deleteFavorite(comic: Comic) = comicDao.deleteFavorite(comic)

    override fun isFavorite(id: String): Single<Boolean> =
        comicDao.isFavorite(id).map { it.isNotEmpty() }
}
