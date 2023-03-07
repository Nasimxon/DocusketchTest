package com.docusketch.common.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun String.getCreatedDate(): String {
    return if (isNotEmpty()) {
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        val date: Date? = formatter.parse(this)
        date?.let {
            SimpleDateFormat("dd.MM.yyyy").format(date)
        } ?: this
    } else ""
}