package com.example.myfirstapp.exstension

import kotlin.math.floor

fun Int.rmpFloor(): Int {
    return floor(this / 1000.0).toInt()
}
