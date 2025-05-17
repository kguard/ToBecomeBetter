package com.kguard.tobecomebetter.baekjoon

// 실버 5 올림픽
// 구현, 정렬
// sortWith(), compareByDescending{}.thenBy{} 등을 사용
// indexOfFirst를 사용하여 처음 나오는 인덱스 찾기
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val country = mutableListOf<Pair<Int, Triple<Int, Int, Int>>>()
    var t: Pair<Int, Triple<Int, Int, Int>> = Pair(0, Triple(0, 0, 0))
    repeat(n) {
        val (a, b, c, d) = readln().split(" ").map { it.toInt() }
        country.add(Pair(a, Triple(b, c, d)))
        if (a == m)
            t = Pair(a, Triple(b, c, d))
    }
    country.sortWith(compareByDescending<Pair<Int, Triple<Int,Int,Int>>>{it.second.first}.thenByDescending { it.second.second }.thenByDescending { it.second.third })
    print(country.indexOfFirst { it.second == t.second } + 1)
}