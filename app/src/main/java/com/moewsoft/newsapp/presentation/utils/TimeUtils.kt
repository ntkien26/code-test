package com.moewsoft.newsapp.presentation.utils

import java.text.SimpleDateFormat
import java.util.*

object TimeUtils {
    fun parseTimeToDDMMYYYY(time: String?): String {
        return try {
            val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
            sdf.timeZone = TimeZone.getTimeZone("GMT")
            val output = SimpleDateFormat("dd-MM-yyyy")
            output.timeZone = TimeZone.getTimeZone("GMT")
            val d: Date = sdf.parse(time)
            output.format(d)
        } catch (exception: Exception) {
            ""
        }
    }
}