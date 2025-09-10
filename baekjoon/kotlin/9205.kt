package com.kguard.tobecomebetter.baekjoon.kotlin

import kotlin.math.abs

// 골드 5 맥주 마시면서 걸어가기
// BFS를 이용해서 문제 해결
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val store = mutableListOf<Pair<Int, Int>>()
        val start = readln().split(" ").map { it.toInt() }.let { (a, b) -> a to b }
        store.add(start)
        repeat(n) {
            store.add(readln().split(" ").map { it.toInt() }.let { (a, b) -> a to b })
        }
        val end = readln().split(" ").map { it.toInt() }.let { (a, b) -> a to b }
        store.add(end)

        val v = MutableList(n + 2) { false }
        val q = ArrayDeque<Int>()
        v[0] = true
        q.add(0)
        while (q.isNotEmpty()) {
            val index = q.removeAt(0)
            if (index == n + 1) // 마지막 end 일때 break
                break
            for (i in 0 until n + 2) {
                if (!v[i] && abs(store[i].first - store[index].first) + abs(store[i].second - store[index].second) <= 1000) { // 거리가 1000 이하고, 방문하지 않았을 때
                    q.add(i)
                    v[i] = true
                }
            }
        }
        println(if (v[n + 1]) "happy" else "sad")
    }
}