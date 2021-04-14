package com.example.comik.utils

import androidx.room.TypeConverter
import com.example.comik.data.model.Image
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable

class ImageTypeConverter : Serializable {
    @TypeConverter
    fun toJson(value: Image): String {
        val type = object : TypeToken<Image>() {}.type
        return Gson().toJson(value, type)
    }

    @TypeConverter
    fun fromJson(value: String): Image {
        val type = object : TypeToken<Image>() {}.type
        return Gson().fromJson(value, type)
    }
}
