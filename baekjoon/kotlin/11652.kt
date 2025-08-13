package com.kguard.tobecomebetter.baekjoon

// 실버 4 카드
// 자료 구조, 정렬, 해시를 사용한 집합과 맵, 집합과 맵
// groupingBy와 sortedWith()를 사용해서 문제 해결
fun main() {
    val n = readln().toInt()
    // 리스트로 풀기
    val list = mutableListOf<Long>()
    repeat(n) { list.add(readln().toLong()) }
    println(list.groupingBy { it }.eachCount().toList().sortedWith(compareByDescending<Pair<Long, Int>> { it.second }.thenBy { it.first })[0].first)

// map으로 풀기
//    val map = mutableMapOf<Long, Int>()
//    repeat(n) {
//        val k = readln().toLong()
//        map.put(k, map.getOrDefault(k,0)+1)
//    }
//    val max = map.maxOf { it.value }
//    println(map.filter { it.value == max }.map { it.key }.sorted()[0])
//    // 위에와 같은 방법
//    println(map.toList().sortedWith(compareByDescending<Pair<Long,Int>> { it.second }.thenBy { it.first })[0].first)
}