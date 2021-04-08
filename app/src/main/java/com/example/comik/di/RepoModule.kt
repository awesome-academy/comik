package com.example.comik.di

import androidx.room.Room
import com.example.comik.data.repository.ComicRepository
import com.example.comik.data.repository.ComicRepositoryImpl
import com.example.comik.data.source.ComicDataSource
import com.example.comik.data.source.local.ComicLocalDataSource
import com.example.comik.data.source.local.database.AppDatabase
import com.example.comik.data.source.local.database.AppDatabase.Companion.DATABASE_NAME
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dbModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }
    single { get<AppDatabase>().comicDao() }
}

val repoComicModule = module {
    single<ComicDataSource.Local> { ComicLocalDataSource(get()) }
    single<ComicRepository> { ComicRepositoryImpl(get(), get()) }
}
