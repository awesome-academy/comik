package com.example.comik.utils

object APIConfig {
    const val BASE_URL = "https://gateway.marvel.com/v1/public/"
    const val API_KEY = "apikey"
    const val HASH = "hash"
    const val TS = "ts"
    const val IMAGE = "/portrait_xlarge.jpg"
    const val IMAGE_NOT_AVAILABLE =
        "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available"
    const val FORMAT_COMIC = "comic"
}

object BUNDLE {
    const val BUNDLE_CHARACTER = "BUNDLE_CHARACTER"
    const val BUNDLE_SERIES = "BUNDLE_SERIES"
    const val BUNDLE_EVENT = "BUNDLE_EVENT"
    const val BUNDLE_CREATOR = "BUNDLE_CREATOR"
    const val BUNDLE_STORE = "BUNDLE_STORE"
}
