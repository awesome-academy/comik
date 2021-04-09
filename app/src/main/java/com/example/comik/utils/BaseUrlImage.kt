package com.example.comik.utils

import com.example.comik.utils.APIConfig.IMAGE
import java.lang.StringBuilder

object BaseUrlImage {
    fun baseUrlImage(string: String) = StringBuilder(string).append(IMAGE).toString()
}
