package com.kguard.tobecomebetter.baekjoon.kotlin

/*
 골드 5 A와 B2
 거꾸로 생각하는 문제, 재귀의 방법으로 문제를 풀기
 거꾸로 할 경우는 두가지의 함수로 나뉘게됨
 1. 마지막에 A 가 인경우 -> 그냥 마지막거 삭제하고 재귀
 2. 처음이 B인 경우 (B를 추가하고, 뒤집기 하기 때문에) -> 뒤집고 마지막거 삭제 하고 재귀
 근데 밑에서 1로 return 되면 그냥 1 return
 */
fun main() {
    val s = readln()
    val t = readln()

    fun check(ss: String): Int {
        if (ss == s)
            return 1

        if (ss.length < s.length)
            return 0

        return if (ss.last() == 'A' && check(ss.dropLast(1)) == 1 ||
            ss.first() == 'B' && check(ss.reversed().dropLast(1)) == 1
        ) {
            1
        } else
            0
    }

    println(check(t))
}