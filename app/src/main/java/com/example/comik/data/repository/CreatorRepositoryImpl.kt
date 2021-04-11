package com.example.comik.data.repository

import com.example.comik.data.model.Creator
import com.example.comik.data.source.CreatorDataSource
import io.reactivex.rxjava3.core.Observable

class CreatorRepositoryImpl(
    private val remote: CreatorDataSource
) : CreatorRepository {

    override fun getCreators(): Observable<List<Creator>> = remote.getCreators().map {
        it.data.results
    }
}
