package com.example.comik.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.comik.base.RxViewModel
import com.example.comik.data.model.Comic
import com.example.comik.data.repository.ComicRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class DetailViewModel(
    private val comicRepository: ComicRepository
) : RxViewModel() {

    private val _comic = MutableLiveData<Comic>()
    val comic: LiveData<Comic>
        get() = _comic

    private val _isEmpty = MutableLiveData<Boolean>()
    val isEmpty: LiveData<Boolean>
        get() = _isEmpty

    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean>
        get() = _isFavorite

    fun initDataDetail(id: Int) {
        getComic(id)
        checkFavorite(id)
    }

    private fun getComic(comicId: Int) {
        comicRepository.getComic(comicId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _comic.value = it
                _isEmpty.value = it.image?.isEmpty()
            }, {
                _error.value
            })
            .addTo(disposables)
    }

    private fun checkFavorite(id: Int) {
        comicRepository.isFavorite(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _isFavorite.value = it
            }, {
                _error.value = it.message.toString()
            })
            .addTo(disposables)
    }

    fun updateFavorite() {
        comic.value?.let { it ->
            if (isFavorite.value == true) {
                comicRepository.deleteFavorite(it)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        _isFavorite.value = false
                    }, {
                        _error.value = it.message.toString()
                    })
                    .addTo(disposables)
            } else {
                comicRepository.insertFavorite(it)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        _isFavorite.value = true
                    }, {
                        _error.value = it.message.toString()
                    })
                    .addTo(disposables)
            }
        }
    }
}
