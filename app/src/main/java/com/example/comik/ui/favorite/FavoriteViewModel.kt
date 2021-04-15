package com.example.comik.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.comik.base.RxViewModel
import com.example.comik.data.model.Comic
import com.example.comik.data.repository.ComicRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class FavoriteViewModel(
    private val comicRepository: ComicRepository
) : RxViewModel() {

    private val _comics = MutableLiveData<List<Comic>>()
    val comics: LiveData<List<Comic>>
        get() = _comics

    init {
        getFavoriteComics()
    }

    private fun getFavoriteComics() {
        comicRepository.getFavorites()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _comics.value = it
            }, {
                _error.value = it.message.toString()
            })
            .addTo(disposables)
    }
}
