package com.kguard.tobecomebetter.baekjoon.kotlin

import kotlin.math.min

// 골드 4 용감한 용사 진수
// 브루트 포스 방식으로 푸는 문제
// 조합으로 풀면 100C50 만해도 시간 초과가 남
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val list = mutableListOf<Triple<Int, Int, Int>>()
    var ans = Int.MAX_VALUE
    repeat(n) {
        list.add(readln().split(" ").map { it.toInt() }.let { (a, b, c) -> Triple(a, b, c) })
    }

    // 힘 과 민첩을 미리 정하고 하는 것
    for (i in 0 until n) {
        for (j in 0 until n) {
            val nowStr = list[i].first // i 번째를 힘으로 생각
            val nowDex = list[j].second // j 번째를 민첩으로 생각

            val possible = mutableListOf<Int>() // 지능이 들어갈 수 있는 모든 가능한 경우의 지능 값

            for (e in list) {
                if (e.first <= nowStr && e.second <= nowDex) { // 힘과 민첩이 모두 상대보다 높아야 함
                    possible.add(e.third) // 더해주기
                }
            }

            if (possible.size >= k) { // 최소한의 K보다 많아야 함
                possible.sort() // 정렬을 해서 최소 값을 뽑기 위함
                val nowInt = possible[k - 1] // k번째의 지능이 최소한의 지능 값이 됨
                ans = min(ans, nowStr + nowDex + nowInt) // 다 더한 것을 비교
            }


        }
    }
    println(ans)
}


// 조합으로 풀기 (시간초과)
/*
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val list = mutableListOf<Triple<Int, Int, Int>>()
    val combs = mutableListOf<Triple<Int, Int, Int>>()
    var min = Int.MAX_VALUE
    repeat(n) {
        list.add(readln().split(" ").map { it.toInt() }.let { (a, b, c) -> Triple(a, b, c) })
    }


    fun comb(count: Int, start: Int) {
        if (count == k) {
            var (f, s, t) = Triple(0, 0, 0)
            combs.forEach {
                if (it.first > f) f = it.first
                if (it.second > s) s = it.second
                if (it.third > t) t = it.third
            }
            min = min(f + s + t, min)
            return
        }

        for (i in start until list.size) {
            combs.add(list[i])
            comb(count + 1, i + 1)
            combs.removeAt(combs.lastIndex)
        }

    }

    comb(0, 0)

    println(min)
}*/
