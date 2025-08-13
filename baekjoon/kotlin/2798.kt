package com.kguard.tobecomebetter.baekjoon

fun main() {
    val a = readln().split(" ").map { it.toInt() }
    val card = readln().split(" ").map { it.toInt() }.toMutableList()
    var result = 0
    for (i in 0..card.size - 3) {
        for (j in i + 1..card.size - 2) {
            for (l in j + 1..card.size - 1) {
                val t = card[i] + card[j] + card[l]
                if (t > result && a[1] >= t)
                    result = t
            }
        }
    }
    print(result)
}