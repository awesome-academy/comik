package com.example.comik.data.model

import com.google.gson.annotations.SerializedName

class ComicResult(
    @SerializedName("results")
    var results: List<Comic>
)
