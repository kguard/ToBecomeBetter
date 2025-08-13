package com.kguard.tobecomebetter.baekjoon

fun main() {
    while (true) {
        val a = readln().split(" ").map { it.toInt() }
        if (a[0] == 0 && a[1] == 0)
            break
        if (a[0] > a[1]) {
            val t = a[0] % a[1]
            if (t == 0)
                println("multiple")
            else
                println("neither")
        } else if (a[0] < a[1]) {
            val t = a[1] % a[0]
            if (t == 0)
                println("factor")
            else
                println("neither")
        }
    }
}