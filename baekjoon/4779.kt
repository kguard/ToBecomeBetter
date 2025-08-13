package com.kguard.tobecomebetter.baekjoon

import java.util.Scanner
import kotlin.math.pow
//실버 3
// 입력 값이 없을때까지 출력
fun main() {
    val input = Scanner(System.`in`)
    while (input.hasNextInt()) {
        val n = input.nextInt()
        println(cantor(n))
    }
}

fun cantor(a: Int): String {
    val n = 3.0.pow(a - 1).toInt()
    return if (a == 0)
        "-"
    else
        cantor(a - 1) + " ".repeat(n) + cantor(a - 1)
}