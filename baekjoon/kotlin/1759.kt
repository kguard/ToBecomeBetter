package com.kguard.tobecomebetter.baekjoon.kotlin

// 골드 5 암호 만들기
// 조합을 이용해서 푸는 기본적인 문제
fun main() {
    val (l, c) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").sorted()
    var string = ""

    fun comb(cnt: Int, start: Int) {
        if (cnt == l) {
            var countM = 0
            var countJ = 0
            string.forEach {
                if (it in listOf('a', 'e', 'i', 'o', 'u'))
                    countM++
                else
                    countJ++
            }
            if (countM >= 1 && countJ >= 2)
                println(string)
            return
        }

        for (i in start until c) {
            string += list[i]
            comb(cnt + 1, i + 1)
            string = string.dropLast(1)
        }
    }

    comb(0, 0)
}