package com.example.comik.ui.listcomic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.comik.base.RxViewModel
import com.example.comik.data.model.Comic
import com.example.comik.data.repository.ComicRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class ListComicViewModel(
    private val comicRepository: ComicRepository
) : RxViewModel() {

    private val _comic = MutableLiveData<List<Comic>>()
    val comic: LiveData<List<Comic>> get() = _comic

    fun getComicsByType(type: String, id: Int) {
        comicRepository.getComicsByType(type, id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _comic.value = it
            }, {
                _error.value = it.message.toString()
            })
            .addTo(disposables)
    }
}
