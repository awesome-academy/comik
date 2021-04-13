package com.example.comik.data.repository

import com.example.comik.data.model.Series
import com.example.comik.data.source.SeriesDataSource
import io.reactivex.rxjava3.core.Observable

class SeriesRepositoryImpl(
    private val remote: SeriesDataSource
) : SeriesRepository {

    override fun getSeries(): Observable<List<Series>> = remote.getSeries().map { it.data.results }
}
