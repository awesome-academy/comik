package com.example.comik.data.model

import com.google.gson.annotations.SerializedName

class StoryResult(
    @SerializedName("results")
    val results: List<Story>
)
