package com.example.comik.data.model

import com.google.gson.annotations.SerializedName

class EventResult(
    @SerializedName("results")
    var results: List<Event>
)
