package com.kguard.tobecomebetter.baekjoon

// 브론즈 3 루미의 진정한™ 보라색 찾기
// 수학, 구현, 사칙연산
// 실수형으로 풀어야 됨
fun main() {
    val (hLow, hHigh) = readln().split(" ").map { it.toDouble() }
    val (sLow, sHigh) = readln().split(" ").map { it.toDouble() }
    val (vLow, vHigh) = readln().split(" ").map { it.toDouble() }
    val (r, g, b) = readln().split(" ").map { it.toDouble() }
    val max = maxOf(r, g, b)
    val min = minOf(r, g, b)
    val v = max
    val s = 255.0 * (v - min) / v
    var h = when (v) {
        r -> {
            60.0 * (g - b) / (v - min)
        }

        g -> {
            120.0 + (60.0 * (b - r) / (v - min))
        }

        b -> {
            240.0 + (60.0 * (r - g) / (v - min))
        }


        else -> {370.0}
    }
    if(h < 0.0)
        h += 360.0

    if (h in hLow..hHigh && s in sLow..sHigh && v in vLow..vHigh)
        println("Lumi will like it.")
    else
        println("Lumi will not like it.")
}

