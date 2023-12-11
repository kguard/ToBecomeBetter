package com.kguard.tobecomebetter.baekjoon

import kotlin.math.pow

fun main() {
    val a = readln().split(" ")
    var sum = 0
    for ((count, i) in a[0].toMutableList().reversed().withIndex()) {
        var b = i.code
        b -= if (b >= 65)
            55
        else
            48
        if (b >= a[1].toInt()) {
            sum = 0
            break
        }
        sum += b * (a[1].toDouble().pow(count).toInt())
    }
    print(sum)
}