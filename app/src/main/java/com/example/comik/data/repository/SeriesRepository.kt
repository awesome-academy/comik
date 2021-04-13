package com.example.comik.data.repository

import com.example.comik.data.model.Series
import io.reactivex.rxjava3.core.Observable

interface SeriesRepository {
    fun getSeries(): Observable<List<Series>>
}
