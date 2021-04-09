package com.example.comik.data.source.remote

import com.example.comik.data.source.EventDataSource
import com.example.comik.data.source.remote.utlis.APIService

class EventRemoteDataSource(
    private val apiService: APIService
) : EventDataSource {

    override fun getEvents() = apiService.getEvents()
}
