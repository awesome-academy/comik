package com.example.comik.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.comik.base.RxViewModel
import com.example.comik.data.model.Event
import com.example.comik.data.repository.EventRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel(
    private val eventRepository: EventRepository
) : RxViewModel() {

    private val _event = MutableLiveData<List<Event>>()
    val event: LiveData<List<Event>> get() = _event

    init {
        getEvents()
    }

    private fun getEvents() {
        eventRepository.getEvents()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _event.value = it.take(4)
            }, {
                _error.value = it.message.toString()
            })
            .addTo(disposables)
    }
}
