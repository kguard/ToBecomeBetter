package com.kguard.tobecomebetter.baekjoon.kotlin

// 실버 5 비밀번호 발음하기
// 그냥 문자열 찾기
fun main() {
    while (true) {
        val password = readln()
        if (password == "end") return
        println("<$password> is ${if (!check(password)) "not acceptable." else "acceptable."}")
    }
}

private fun check(password: String): Boolean {
    val m = hashSetOf('a', 'e', 'i', 'o', 'u')
    // 1번 조건
    if (password.none { it in m })
        return false
    // 2번 조건
    var countA = 0
    var countB = 0
    for (i in password.indices) {
        if (password[i] in m) {
            countA++
            countB = 0
        } else {
            countB++
            countA = 0
        }
        if (countB == 3 || countA == 3)
            return false
        // 3번 조건
        if (i > 0 && password[i] == password[i - 1])
            if (password[i] != 'e' && password[i] != 'o')
                return false
    }
    return true
}
