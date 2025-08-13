package com.kguard.tobecomebetter.baekjoon

// 실버 5 방 번호
// 구현
fun main() {
    val n = readln()
    val c = MutableList(10) { 0 }
    for (i in n) {
        if (i.toString().toInt() == 9)
            c[6]++
        else
            c[i.toString().toInt()]++
    }
    c[6] = c[6] / 2 + c[6] % 2
    print(c.max())
}