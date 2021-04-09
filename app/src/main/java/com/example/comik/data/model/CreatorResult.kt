package com.example.comik.data.model

import com.google.gson.annotations.SerializedName

class CreatorResult(
    @SerializedName("results")
    val results: List<Creator>
)
