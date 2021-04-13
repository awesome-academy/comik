package com.example.comik.data.model

import com.google.gson.annotations.SerializedName

class SeriesResult(
    @SerializedName("results")
    val results: List<Series>
)
