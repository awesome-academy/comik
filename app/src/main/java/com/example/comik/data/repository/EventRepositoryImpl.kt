package com.example.comik.data.repository

import com.example.comik.data.model.Event
import com.example.comik.data.source.EventDataSource
import io.reactivex.rxjava3.core.Observable

class EventRepositoryImpl(
    private val remote: EventDataSource
) : EventRepository {

    override fun getEvents(): Observable<List<Event>> {
        return remote.getEvents().map {
            it.data.results
        }
    }
}
