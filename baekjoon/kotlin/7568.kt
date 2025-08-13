package com.kguard.tobecomebetter.baekjoon

// 실버 5 덩치
// 구현 브루트포스 알고리즘
fun main() {
    val n = readln().toInt()
    val people = mutableListOf<Pair<Int, Int>>()
    val rate = MutableList<Int>(n) { 1 }
    repeat(n) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        people.add(Pair(a, b))
    }
    for (i in people.indices)
        for (j in people.indices)
            if (check(people[i], people[j]))
                rate[j]++
    rate.forEach { print("$it ") }
}

private fun check(a: Pair<Int, Int>, b: Pair<Int, Int>): Boolean {
    return a.first > b.first && a.second > b.second
}