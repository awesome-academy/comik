package com.example.comik.data.model

import com.google.gson.annotations.SerializedName

class ComicResponse(
    @SerializedName("data")
    var data: ComicResult
)
