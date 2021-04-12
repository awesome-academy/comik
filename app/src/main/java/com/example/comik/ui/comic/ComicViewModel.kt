package com.example.comik.ui.comic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.comik.base.RxViewModel
import com.example.comik.data.model.Comic
import com.example.comik.data.repository.ComicRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class ComicViewModel(
    private val comicRepository: ComicRepository
) : RxViewModel() {

    private val _comic = MutableLiveData<List<Comic>>()
    val comic: LiveData<List<Comic>>
        get() = _comic

    private val _isEmpty = MutableLiveData<Boolean>()
    val isEmpty: LiveData<Boolean>
        get() = _isEmpty

    init {
        getComics()
    }

    private fun getComics() {
        comicRepository.getComics()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _comic.value = it
            }, {
                _error.value = it.message.toString()
            })
            .addTo(disposables)
    }

    fun getComicByYear(format: String, year: Int) {
        comicRepository.getComicByYear(format, year)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _comic.value = it
                _isEmpty.value = it.isEmpty()
            }, {
                _error.value = it.message.toString()
            })
            .addTo(disposables)
    }
}
