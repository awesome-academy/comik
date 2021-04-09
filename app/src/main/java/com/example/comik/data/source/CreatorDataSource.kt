package com.example.comik.data.source

import com.example.comik.data.model.CreatorResponse
import io.reactivex.rxjava3.core.Observable

interface CreatorDataSource {
    fun getCreators(): Observable<CreatorResponse>
}
