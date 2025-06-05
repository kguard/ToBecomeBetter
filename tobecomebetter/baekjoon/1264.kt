package com.kguard.tobecomebetter.baekjoon

// 브론즈 4 모음의 개수
// 구현, 문자열
fun main() {
    val moum = listOf('a', 'A', 'o', 'O', 'i', 'I', 'e', 'E', 'u', 'U')
    while (true) {
        val line = readln()
        if (line == "#")
            break
        var count = 0
        for (i in line)
            if (i in moum)
                count++
        println(count)
    }
}