package com.kguard.tobecomebetter.baekjoon.kotlin

/*
    골드 5 Moo 게임
    분할 정복(재귀)를 이용해서 해결하는 문제
    16974와 비슷한 문제
    n을 기준으로 (이전) (가운데) (이후) 이렇게 3개로 나눠서 작업
    이전, 이후는 재귀로 접근하도록 함
 */
fun main() {
    val n = readln().toLong()
    val length = mutableListOf<Long>()
    length.add(3)
    while (length.last() < n) {
        length.add(length.last() * 2 + (length.size + 3))
    }

    fun count(k: Long, curN: Int) {
        if (curN == 0) {
            print(if (k == 1L) "m" else "o")
            return
        }
        val prev = length[curN - 1]
        val mid = curN + 3

        when (k) {
            in 1..prev -> count(k, curN - 1)
            in prev + 1..prev + mid -> {
                print(if (k == prev + 1) "m" else "o")
                return
            }
            else -> count(k - prev - mid, curN - 1)
        }
    }
    count(n, length.size)
}