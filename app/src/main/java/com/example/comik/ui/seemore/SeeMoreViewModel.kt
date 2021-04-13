package com.example.comik.ui.seemore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.comik.base.RxViewModel
import com.example.comik.data.model.*
import com.example.comik.data.repository.*
import com.example.comik.utils.APIConfig
import com.example.comik.utils.BUNDLE.BUNDLE_CHARACTER
import com.example.comik.utils.BUNDLE.BUNDLE_CREATOR
import com.example.comik.utils.BUNDLE.BUNDLE_EVENT
import com.example.comik.utils.BUNDLE.BUNDLE_SERIES
import com.example.comik.utils.BUNDLE.BUNDLE_STORY
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class SeeMoreViewModel(
    private val characterRepository: CharacterRepository,
    private val storyRepository: StoryRepository,
    private val seriesRepository: SeriesRepository,
    private val eventRepository: EventRepository,
    private val creatorRepository: CreatorRepository
) : RxViewModel() {

    private val _event = MutableLiveData<List<Event>>()
    val event: LiveData<List<Event>>
        get() = _event

    private val _creator = MutableLiveData<List<Creator>>()
    val creator: LiveData<List<Creator>>
        get() = _creator

    private val _character = MutableLiveData<List<Character>>()
    val character: LiveData<List<Character>>
        get() = _character

    private val _series = MutableLiveData<List<Series>>()
    val series: LiveData<List<Series>>
        get() = _series

    private val _story = MutableLiveData<List<Story>>()
    val story: LiveData<List<Story>>
        get() = _story

    private val _type = MutableLiveData<String>()
    val type: LiveData<String>
        get() = _type

    fun getSeeMore(bundle: String) {
        when (bundle) {
            BUNDLE_CHARACTER -> {
                getCharacters()
                _type.value = BUNDLE_CHARACTER
            }
            BUNDLE_SERIES -> {
                getSeries()
                _type.value = BUNDLE_SERIES
            }
            BUNDLE_EVENT -> {
                getEvents()
                _type.value = BUNDLE_EVENT
            }
            BUNDLE_CREATOR -> {
                getCreators()
                _type.value = BUNDLE_CREATOR
            }
            BUNDLE_STORY -> {
                getStories()
                _type.value = BUNDLE_STORY
            }
        }
    }

    private fun getEvents() {
        eventRepository.getEvents()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _event.value = it
            }, {
                _error.value = it.message.toString()
            })
            .addTo(disposables)
    }

    private fun getCreators() {
        creatorRepository.getCreators()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _creator.value = it
            }, {
                _error.value = it.message.toString()
            })
            .addTo(disposables)
    }

    private fun getCharacters() {
        characterRepository.getCharacters()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                it.filter { character ->
                    character.thumbnail.path != APIConfig.IMAGE_NOT_AVAILABLE
                }
            }
            .subscribe({
                _character.value = it
            }, {
                _error.value = it.message.toString()
            })
            .addTo(disposables)
    }

    private fun getStories() {
        storyRepository.getStories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _story.value = it
            }, {
                _error.value = it.message.toString()
            })
            .addTo(disposables)
    }

    private fun getSeries() {
        seriesRepository.getSeries()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                it.filter { series ->
                    series.thumbnail.path != APIConfig.IMAGE_NOT_AVAILABLE
                }
            }
            .subscribe({
                _series.value = it
            }, {
                _error.value = it.message.toString()
            })
            .addTo(disposables)
    }
}
