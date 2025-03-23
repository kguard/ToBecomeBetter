package com.kguard.tobecomebetter.baekjoon

// 브론즈 3 1교시: 가정
// 구현
fun main() {
    var (f, c, e, b) = readln().split(" ").map { it.toInt() }
    var cookie = 0
    val (f1, c1, e1, b1) = readln().split(" ").map { it.toInt() }
    val q = readln().toInt()
    repeat(q) {
        val (a, t) = readln().split(" ").map { it.toInt() }
        when (a) {
            1 -> {
                if (f - (f1 * t) < 0 || c - (c1 * t) < 0 || e - (e1 * t) < 0 || b - (b1 * t) < 0)
                    println("Hello, siumii")
                else {
                    f -= f1 * t
                    c -= c1 * t
                    e -= e1 * t
                    b -= b1 * t
                    cookie += t
                    println(cookie)
                }
            }

            2 -> {
                f += t
                println(f)
            }

            3 -> {
                c += t
                println(c)
            }

            4 -> {
                e += t
                println(e)
            }

            5 -> {
                b += t
                println(b)
            }
        }
    }
}