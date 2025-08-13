package com.kguard.tobecomebetter.baekjoon

// 실버 5 CD
// 자료 구조, 이분 탐색, 해시를 사용한 집합과 맵, 두 포인터(투 포인터)

// 이분 탐색으로 문제 해결하는 방식
fun main() {
    while (true) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        if (n == 0 && m == 0) break
        val a = mutableListOf<Long>()
        var count = 0
        repeat(n) { a.add(readln().toLong()) }
        repeat(m) { if (lowerBound(a, readln().toLong())) count++ }
        println(count)
    }
}

private fun lowerBound(list: List<Long>, now: Long): Boolean {
    var leftIndex = 0
    var rightIndex = list.lastIndex
    var midIndex: Int
    while (leftIndex < rightIndex) {
        midIndex = (leftIndex + rightIndex) / 2
        if (now > list[midIndex]) leftIndex = midIndex + 1
        else rightIndex = midIndex
    }
    return now == list[rightIndex]
}

 // 투 포인터로 문제 해결하는 방식
//fun main() {
//    while (true) {
//        val (n, m) = readln().split(" ").map { it.toInt() }
//        if (n == 0 && m == 0) break
//        val a = mutableListOf<Long>()
//        val b = mutableListOf<Long>()
//        var count = 0
//        var aIndex = 0
//        var bIndex = 0
//        repeat(n) { a.add(readln().toLong()) }
//        repeat(m) { b.add(readln().toLong()) }
//        while (aIndex < n) {
//            if (a[aIndex] == b[bIndex]) {
//                aIndex++
//                bIndex++
//                count++
//            } else if (a[aIndex] < b[bIndex])
//                aIndex++
//            else if (b[bIndex] < a[aIndex])
//                bIndex++
//        }
//        println(count)
//    }
//}