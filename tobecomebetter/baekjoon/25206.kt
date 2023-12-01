package com.kguard.tobecomebetter.baekjoon

fun main() {
    var sum: Double = 0.0
    var count = 0.0
    repeat(20) {
        val a = readln().split(" ")
        sum += when (a[2]) {
            "A+" -> a[1].toDouble() * 4.5
            "A0" -> a[1].toDouble() * 4.0
            "B+" -> a[1].toDouble() * 3.5
            "B0" -> a[1].toDouble() * 3.0
            "C+" -> a[1].toDouble() * 2.5
            "C0" -> a[1].toDouble() * 2.0
            "D+" -> a[1].toDouble() * 1.5
            "D0" -> a[1].toDouble() * 1.0
            "F" -> a[1].toDouble() * 0.0
            else -> 0.0
        }
        if (a[2] != "P")
            count += a[1].toDouble()
    }
    println((sum / count).toFloat())
}