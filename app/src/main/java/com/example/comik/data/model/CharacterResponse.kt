package com.example.comik.data.model

import com.google.gson.annotations.SerializedName

class CharacterResponse(
    @SerializedName("data")
    val data: CharacterResult
)
