package com.example.comik.data.model

import com.google.gson.annotations.SerializedName

class CharacterResult(
    @SerializedName("results")
    val results: List<Character>
)
