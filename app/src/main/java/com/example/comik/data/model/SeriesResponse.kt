package com.example.comik.data.model

import com.google.gson.annotations.SerializedName

class SeriesResponse(
    @SerializedName("data")
    val data: SeriesResult
)
