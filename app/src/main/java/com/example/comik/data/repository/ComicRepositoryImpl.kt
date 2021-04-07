package com.example.comik.data.repository

import com.example.comik.data.model.Comic
import com.example.comik.data.source.ComicDataSource

class ComicRepositoryImpl(
    private val local: ComicDataSource.Local
) : ComicRepository {

    override fun getFavorites() = local.getFavorites()

    override fun insertFavorite(comic: Comic) = local.insertFavorite(comic)

    override fun deleteFavorite(comic: Comic) = local.deleteFavorite(comic)

    override fun isFavorite(id: String) = local.isFavorite(id)
}
