package com.example.comik.data.source

import com.example.comik.data.model.SeriesResponse
import io.reactivex.rxjava3.core.Observable

interface SeriesDataSource {
    fun getSeries(): Observable<SeriesResponse>
}
