package com.example.comik.data.source.local.database.dao

import androidx.room.*
import com.example.comik.data.model.Comic
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface ComicDao {
    @Query("SELECT * FROM comic")
    fun getFavorites(): Observable<List<Comic>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertFavorite(comic: Comic): Completable

    @Delete
    fun deleteFavorite(comic: Comic): Completable

    @Query("SELECT * FROM comic WHERE id =:id")
    fun isFavorite(id: String): Single<List<Comic>>
}
