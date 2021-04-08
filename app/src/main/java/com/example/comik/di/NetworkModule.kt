package com.example.comik.di

import com.example.comik.BuildConfig
import com.example.comik.utils.APIConfig.API_KEY
import com.example.comik.utils.APIConfig.BASE_URL
import com.example.comik.utils.APIConfig.HASH
import com.example.comik.utils.APIConfig.TS
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    fun initHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor { chain ->
            val original = chain.request()
            val url = original.url().newBuilder()
                .addQueryParameter(TS, BuildConfig.TS)
                .addQueryParameter(API_KEY, BuildConfig.API_KEY)
                .addQueryParameter(HASH, BuildConfig.HASH)
                .build()
            val request = original.newBuilder().url(url).build()
            chain.proceed(request)
        }
        return builder.build()
    }

    fun initRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(client)
            .build()
    }

    single { initHttpClient() }
    single { initRetrofit(get()) }
}
