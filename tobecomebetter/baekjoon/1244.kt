package com.kguard.tobecomebetter.baekjoon

// 실버 4 스위치 켜고 끄기
// 구현, 시뮬레이션
fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.toMutableList()
    val m = readln().toInt()
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        var index = b - 1
        when (a) {
            1 -> {
                while (index < list.size) {
                    if (list[index] == 1) list[index] = 0 else list[index] = 1
                    index += b
                }
            }

            2 -> {
                if (list[index] == 1) list[index] = 0 else list[index] = 1
                var s = index - 1
                var e = index + 1
                while (e < list.size && 0 <= s) {
                    if (list[s] == list[e]) {
                        if (list[s] == 1) list[s] = 0 else list[s] = 1
                        if (list[e] == 1) list[e] = 0 else list[e] = 1
                    } else
                        break
                    s--
                    e++
                }
            }
        }
    }
    for (i in 0 until n) {
        if ((i + 1) % 20 == 0)
            println("${list[i]} ")
        else
            print("${list[i]} ")
    }
}