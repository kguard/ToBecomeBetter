package com.kguard.tobecomebetter.baekjoon

// 브론즈 1 임스의 잠수맵
// 구현, 그리디 알고리즘, 시뮬레이션
fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    val (bt, ct) = readln().split(" ").map { it.toInt() }
    var exp = (250 - readln().toInt()) * 100
    var minute = 0
    val cMax = c * 30 * ct
    val bMax = b * 30 * bt
    if (exp > cMax) {
        exp -= cMax
        minute += 30 * ct
        if (exp > bMax) {
            exp -= bMax
            minute += 30 * bt
            minute += if (exp % a == 0)
                exp / a
            else
                exp / a + 1
        } else {
            minute += if (exp % b == 0)
                exp / b
            else
                exp / b + 1
        }
    } else {
        minute += if (exp % c == 0)
            exp / c
        else
            exp / c + 1
    }
    println(minute)
}

//fun main() {
//    val (a, b, c) = readln().split(" ").map { it.toInt() }
//    var (bt, ct) = readln().split(" ").map { it.toInt() * 30 }
//    var exp = (250 - readln().toInt()) * 100
//    var minute = 0
//    while (exp > 0) {
//        if (ct > 0) {
//            exp -= c
//            ct--
//        } else if (bt > 0) {
//            exp -= b
//            bt--
//        } else
//            exp -= a
//        minute++
//    }
//    println(minute)
//}


