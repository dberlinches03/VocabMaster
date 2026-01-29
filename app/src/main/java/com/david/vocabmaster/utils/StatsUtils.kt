package com.david.vocabmaster.utils

import java.util.concurrent.TimeUnit

fun daysBetween (a: Long, b: Long): Int {
    val diff = b - a
    return TimeUnit.MILLISECONDS.toDays(diff).toInt()
}