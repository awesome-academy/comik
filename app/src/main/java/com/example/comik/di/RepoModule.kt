package com.example.comik.di

import androidx.room.Room
import com.example.comik.data.repository.*
import com.example.comik.data.source.ComicDataSource
import com.example.comik.data.source.CreatorDataSource
import com.example.comik.data.source.EventDataSource
import com.example.comik.data.source.local.ComicLocalDataSource
import com.example.comik.data.source.local.database.AppDatabase
import com.example.comik.data.source.local.database.AppDatabase.Companion.DATABASE_NAME
import com.example.comik.data.source.remote.ComicRemoteDataSource
import com.example.comik.data.source.remote.CreatorRemoteDataSource
import com.example.comik.data.source.remote.EventRemoteDataSource
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
    single<ComicDataSource.Remote> { ComicRemoteDataSource(get()) }
    single<ComicRepository> { ComicRepositoryImpl(get(), get()) }
}

val repoEventModule = module {
    single<EventDataSource> { EventRemoteDataSource(get()) }
    single<EventRepository> { EventRepositoryImpl(get()) }
}

val repoCreatorModule = module {
    single<CreatorDataSource> { CreatorRemoteDataSource(get()) }
    single<CreatorRepository> { CreatorRepositoryImpl(get()) }
}
