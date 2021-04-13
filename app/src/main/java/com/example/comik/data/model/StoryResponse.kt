package com.example.comik.data.model

import com.google.gson.annotations.SerializedName

class StoryResponse(
    @SerializedName("data")
    val data: StoryResult
)
