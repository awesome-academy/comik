package com.example.comik.data.source.remote

import com.example.comik.data.source.EventsDataSource
import com.example.comik.data.source.remote.utlis.APIService

class EventRemoteDataSource(
    private val apiService: APIService
) : EventsDataSource {

    override fun getEvents() = apiService.getEvents()
}
